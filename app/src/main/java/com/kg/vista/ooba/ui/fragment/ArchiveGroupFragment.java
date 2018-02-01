package com.kg.vista.ooba.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.ui.activity.App;
import com.kg.vista.ooba.ui.activity.GroupInfoActivity;
import com.kg.vista.ooba.ui.activity.UsersManagement;
import com.kg.vista.ooba.adapter.GroupOnAdapter;
import com.kg.vista.ooba.model.Item.GroupItem;
import com.kg.vista.ooba.model.dto.GroupOnDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArchiveGroupFragment extends Fragment {

    private ArrayList<GroupItem> groupItem= new ArrayList<>();
    private GroupOnAdapter groupAdapter;

    private ListView lvArchive;

    private String ID;
    private String url;
    private String type;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_archive_group, container, false);

        url = "groupon/show";
       // type = "processing";

        ID = UsersManagement.getUserData(getActivity());

        lvArchive = (ListView) rootView.findViewById(R.id.lvArchive);
        lvArchive.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String status = groupItem.get(i).getStatus();
                String goodTitle = groupItem.get(i).getTitle();
                String oldCost = groupItem.get(i).getPrice();
                String articul = groupItem.get(i).getProductId();
//                String newCost = groupItem.get(i).getNewCost();
                String image = groupItem.get(i).getImage();
                Intent intent = new Intent(view.getContext(), GroupInfoActivity.class);
                intent.putExtra("goodTitle", goodTitle);
                intent.putExtra("oldCost", oldCost);
                intent.putExtra("articul", articul);
                intent.putExtra("status", status);
//                intent.putExtra("newCost", newCost);
                intent.putExtra("image", image);
                startActivity(intent);
            }
        });

        show();
        groupAdapter = new GroupOnAdapter(rootView.getContext(), groupItem);
        lvArchive.setAdapter(groupAdapter);

        return rootView;

    }

    private void show() {
        App.api().showGroup(url, "8").enqueue(new Callback<List<GroupOnDTO>>() {
            @Override
            public void onResponse(Call<List<GroupOnDTO>> call, Response<List<GroupOnDTO>> response) {
               groupAdapter.notifyDataSetChanged();
                List<GroupOnDTO> groupOnDTO = response.body();
                for (int i = 0; i < groupOnDTO.size(); i++) {
                    GroupOnDTO item = groupOnDTO.get(i);
                        groupItem.add(GroupItem.of(item));
                }
            }

            @Override
            public void onFailure(Call<List<GroupOnDTO>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getActivity().getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
