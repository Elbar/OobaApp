package kg.ooba.mobile.android.adapters;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import kg.ooba.mobile.android.R;
import kg.ooba.mobile.android.activities.App;
import kg.ooba.mobile.android.activities.PostSettingsActivity;
import kg.ooba.mobile.android.model.Item.AddressItem;
import kg.ooba.mobile.android.model.dto.DeleteAddressDTO;
import kg.ooba.mobile.android.model.dto.UpdateAddressDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aizhan on 9/2/17.
 */

public class PostSettingsAdapter extends BaseAdapter {

    private Context contxt;
    private LayoutInflater lInflater;
    private List<AddressItem> addressItems;
    private ImageButton deleteBtn;
    private ImageButton refreshBtn;
    private String ID;
    private String url;
    private String address_id;
    private String name;
    private String address;
    private String phone;
    private Dialog dialog;
    private EditText nameEditText;
    private EditText contactEditText;
    private EditText phoneEditText;
    private Button saveBtn;

    public PostSettingsAdapter(Context context, List<AddressItem> addressItem, String ID) {
        contxt = context;
        addressItems = addressItem;
        lInflater = (LayoutInflater) contxt
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.ID=ID;
    }

    @Override
    public int getCount() {
        return addressItems.size();
    }

    @Override
    public Object getItem(int position) {
        return addressItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.address_item, parent, false);
        }

        final AddressItem a = getAddresses(position);

        deleteBtn = (ImageButton) view.findViewById(R.id.data_delete);
        refreshBtn = (ImageButton) view.findViewById(R.id.data_refresh);
        ((TextView) view.findViewById(R.id.out_user_name)).setText(a.getName());
        ((TextView) view.findViewById(R.id.out_user_contact)).setText(a.getAddress());
        ((TextView) view.findViewById(R.id.out_user_phone)).setText(a.getPhone());

        dialog = new Dialog(contxt);
        dialog.setTitle("Обновить информацию");

        dialog.setContentView(R.layout.update_address_dialog);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address_id = a.getAddress_id();
                url = "profile/address/delete";
                App.api().deleteAddress(url, ID, address_id).enqueue(new Callback<DeleteAddressDTO>() {
                    @Override
                    public void onResponse(Call<DeleteAddressDTO> call, Response<DeleteAddressDTO> response) {
                        notifyDataSetChanged();
                        int sql = response.body().getSql();
                        if (sql==0) {
                            addressItems.remove(a);
                            notifyDataSetChanged();
                            Toast.makeText(contxt.getApplicationContext(), "Адрес успешно удален", Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(contxt.getApplicationContext(), "Произошла ошибка", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DeleteAddressDTO> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(contxt.getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEditText = (EditText) dialog.findViewById(R.id.dialogNameEdit);
                contactEditText = (EditText) dialog.findViewById(R.id.dialogContactEdit);
                phoneEditText = (EditText) dialog.findViewById(R.id.dialogPhoneEdit);
                saveBtn = (Button) dialog.findViewById(R.id.data_save);

                dialog.show();

                nameEditText.setText(a.getName());
                contactEditText.setText(a.getAddress());
                phoneEditText.setText(a.getPhone());
                notifyDataSetChanged();

                saveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        address_id = a.getAddress_id();
                        url = "profile/address/update";

                        name = nameEditText.getText().toString().trim();
                        address = contactEditText.getText().toString().trim();
                        phone = phoneEditText.getText().toString().trim();

                        App.api().updateAddress(url, ID, address_id,name, phone, address).enqueue(new Callback<UpdateAddressDTO>() {
                            @Override
                            public void onResponse(Call<UpdateAddressDTO> call, Response<UpdateAddressDTO> response) {
                                notifyDataSetChanged();
                                int sql = response.body().getSql();
                                if (sql==0) {
                                    notifyDataSetChanged();
                                    Toast.makeText(contxt.getApplicationContext(), "Данные успешно обновились", Toast.LENGTH_LONG).show();
                                    addressItems.remove(a);
                                    notifyDataSetChanged();
                                    ((PostSettingsActivity) contxt).showData();
                                }
                                else
                                    Toast.makeText(contxt.getApplicationContext(), "Произошла ошибка", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<UpdateAddressDTO> call, Throwable t) {
                                t.printStackTrace();
                                Toast.makeText(contxt.getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                            }

                        });
                    }
                });
            }
        });

        return view;
    }

    AddressItem getAddresses(int position) {
        return ((AddressItem) getItem(position));
    }

}
