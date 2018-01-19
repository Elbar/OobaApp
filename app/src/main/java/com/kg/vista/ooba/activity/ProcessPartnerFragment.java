package com.kg.vista.ooba.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.PartnerAdapter;
import com.kg.vista.ooba.model.Item.PartnerItem;
import com.kg.vista.ooba.model.dto.PartnerItemDTO;
import com.kg.vista.ooba.model.dto.PartnerListDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProcessPartnerFragment extends Fragment {

    private ArrayList<PartnerItem> partnerItems = new ArrayList<>();
    private PartnerAdapter partnerAdapter;

    private ListView lvProcess;
    private TextView sellerName;

    private String ID;
    private String url;
    private String type;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_process_partner, container, false);

        lvProcess = (ListView) rootView.findViewById(R.id.lvProcess);

        url = "promotion";
        type = "processing";

        ID = UsersManagement.getUserData(getActivity());

        lvProcess.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String clientId = partnerItems.get(i).getClientId();
                String seller = partnerItems.get(i).getSeller();
                String statusText = partnerItems.get(i).getStatusText();
                String picUrl = partnerItems.get(i).getPicUrl();
                String quantity = partnerItems.get(i).getQuantity();
                int goodsPrice = partnerItems.get(i).getGoodsPrice();
                int amount = partnerItems.get(i).getAmount();
                double bonusAmount = partnerItems.get(i).getBonusAmount();
                String promoCode = partnerItems.get(i).getPromoCode();


                Intent intent = new Intent(view.getContext(), PartnerInfoActivity.class);

                intent.putExtra("clientId", clientId);
                intent.putExtra("seller", seller);
                intent.putExtra("statusText", statusText);
                intent.putExtra("picUrl", picUrl);
                intent.putExtra("quantity", quantity);
                intent.putExtra("goodPrice", goodsPrice);
                intent.putExtra("amount", amount);
                intent.putExtra("bonusAmount", bonusAmount);
                intent.putExtra("promoCode", promoCode);

                startActivity(intent);
            }
        });

        show();

        partnerAdapter = new PartnerAdapter(rootView.getContext(), partnerItems);
        lvProcess.setAdapter(partnerAdapter);

        return rootView;
    }

    private void show() {
        App.api().partner(url, "10", type).enqueue(new Callback<List<PartnerListDTO>>() {
            @Override
            public void onResponse(Call<List<PartnerListDTO>> call, Response<List<PartnerListDTO>> response) {
                partnerAdapter.notifyDataSetChanged();
                List<PartnerListDTO> partnerListDTO = response.body();
                for (int i = 0; i < partnerListDTO.size(); i++) {
                    for (PartnerItemDTO item : partnerListDTO.get(i).getList())
                        partnerItems.add(PartnerItem.of(item));
                }
            }

            @Override
            public void onFailure(Call<List<PartnerListDTO>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getActivity().getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
