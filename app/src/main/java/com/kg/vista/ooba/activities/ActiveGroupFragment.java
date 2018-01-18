package com.kg.vista.ooba.activities;

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
import com.kg.vista.ooba.adapters.GroupOnAdapter;
import com.kg.vista.ooba.model.Item.GroupItem;

import com.kg.vista.ooba.model.dto.GroupOnDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActiveGroupFragment extends Fragment {

    private ArrayList<GroupItem> groupItem = new ArrayList<>();
    private GroupOnAdapter groupAdapter;

    private ListView lvActive;

    private String ID;
    private String url;
    private String type;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activ_group, container, false);

        lvActive = (ListView) rootView.findViewById(R.id.lvGroup);

        url = "groupon/show";
        // type = "processing";

        ID = UsersManagement.getUserData(getActivity());

        lvActive.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String status = groupItem.get(i).getStatus();
                String goodTitle = groupItem.get(i).getTitle();
                String oldCost = groupItem.get(i).getPrice();
//                String newCost = groupItem.get(i).getNewCost();
                String image = groupItem.get(i).getImage();
                String articul = groupItem.get(i).getProductId();
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
        lvActive.setAdapter(groupAdapter);

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
