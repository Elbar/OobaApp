package kg.ooba.mobile.android.api;

import kg.ooba.mobile.android.model.Item.NotificationItem;
import kg.ooba.mobile.android.model.MainRequest;

import java.util.List;


import kg.ooba.mobile.android.model.OtherProductsOfSeller;
import kg.ooba.mobile.android.model.Product;
import kg.ooba.mobile.android.model.ProductConfig;
import kg.ooba.mobile.android.model.body.LoginBody;
import kg.ooba.mobile.android.model.body.MFListBody;
import kg.ooba.mobile.android.model.body.RegistrationBody;
import kg.ooba.mobile.android.model.dto.AddAddressDTO;
import kg.ooba.mobile.android.model.dto.AddressDTO;
import kg.ooba.mobile.android.model.dto.BalanceDTO;
import kg.ooba.mobile.android.model.dto.BasketListDTO;
import kg.ooba.mobile.android.model.dto.ClearBasketDTO;
import kg.ooba.mobile.android.model.dto.DeleteAddressDTO;
import kg.ooba.mobile.android.model.dto.DeleteGoodDTO;
import kg.ooba.mobile.android.model.dto.GroupOnDTO;
import kg.ooba.mobile.android.model.dto.LoginDTO;
import kg.ooba.mobile.android.model.dto.MFListDTO;
import kg.ooba.mobile.android.model.dto.MFSaveDTO;
import kg.ooba.mobile.android.model.dto.NotificationListDTO;
import kg.ooba.mobile.android.model.dto.OrderGoodDTO;
import kg.ooba.mobile.android.model.dto.PartnerListDTO;
import kg.ooba.mobile.android.model.dto.PaymentsListDTO;
import kg.ooba.mobile.android.model.dto.PaymentsStatusDTO;
import kg.ooba.mobile.android.model.dto.RegistrationDTO;
import kg.ooba.mobile.android.model.dto.SecurityDTO;
import kg.ooba.mobile.android.model.dto.UpdateAddressDTO;
import kg.ooba.mobile.android.model.dto.UpdateDataDTO;
import kg.ooba.mobile.android.model.dto.UpdateGoodDTO;
import kg.ooba.mobile.android.model.dto.UserListDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static kg.ooba.mobile.android.api.conf.Config.BASE_URL;

/**
 * Created by aizhan on 9/2/17.
 */

public interface ApiService {

    @POST("?url=registration")
    Call<RegistrationDTO> registration(@Body RegistrationBody body);

    @POST("?url=login")
    Call<LoginDTO> login(@Body LoginBody body);

    @GET(BASE_URL)
    Call<UserListDTO> user(@Query("url") String url, @Query("user_id") String user_id);

    @GET(BASE_URL)
    Call<UpdateDataDTO> updateUser(@Query("url") String url, @Query("user_id") String user_id, @Query("fio") String fio, @Query("idcard") String idcard, @Query("sex") int sex, @Query("birthday") String birthday, @Query("mobile_phone") String mobile_phone);

    @GET(BASE_URL)
    Call<SecurityDTO> security(@Query("url") String url, @Query("user_id") String user_id, @Query("old_pass") String old_pass, @Query("new_pass") String new_pass, @Query("retry_pass") String retry_pass);

    @GET(BASE_URL)
    Call<List<AddressDTO>> address(@Query("url") String url, @Query("user_id") String user_id);

    @GET(BASE_URL)
    Call<AddAddressDTO> addAddress(@Query("url") String url, @Query("user_id") String user_id, @Query("fio") String fio, @Query("address") String address, @Query("mobile_phone") String mobile_phone);

    @GET(BASE_URL)
    Call<DeleteAddressDTO> deleteAddress(@Query("url") String url, @Query("user_id") String user_id, @Query("address_id") String address_id);

    @GET(BASE_URL)
    Call<UpdateAddressDTO> updateAddress(@Query("url") String url, @Query("user_id") String user_id, @Query("address_id") String address_id, @Query("fio") String fio, @Query("mobile_phone") String mobile_phone, @Query("address") String address);

    @GET(BASE_URL)
    Call<PaymentsListDTO> payments(@Query("url") String url, @Query("user_id") String user_id, @Query("type") String type);

    @GET(BASE_URL)
    Call<List<BalanceDTO>> balance(@Query("url") String url, @Query("user_id") String user_id, @Query("type") String type);

    @GET(BASE_URL)
    Call<PaymentsStatusDTO> status(@Query("url") String url, @Query("user_id") String user_id);

    @GET(BASE_URL)
    Call<List<PartnerListDTO>> partner(@Query("url") String url, @Query("user_id") String user_id, @Query("type") String type);

    @GET(BASE_URL)
    Call<BasketListDTO> basket(@Query("url") String url, @Query("geo") String geo, @Query("user_id") String id);

    @GET(BASE_URL)
    Call<ClearBasketDTO> clearBasket(@Query("url") String url, @Query("user_id") String user_id, @Query("geo") String geo);

    @GET(BASE_URL)
    Call<DeleteGoodDTO> deleteGood(@Query("url") String url, @Query("rec_id") String rec_id, @Query("user_id") String user_id);

    @GET(BASE_URL)
    Call<UpdateGoodDTO> updateGood(@Query("url") String url, @Query("rec_id") String rec_id, @Query("user_id") String user_id, @Query("comment") String comment, @Query("count") String count);

    @GET(BASE_URL)
    Call<OrderGoodDTO> orderGood(@Query("url") String url, @Query("user_id") String user_id, @Query("address") String address_id, @Query("shipping") String shipping, @Query("goods_id") List<String> goods_id, @Query("comment") String comment);

    @GET(BASE_URL)
    Call<MFListDTO> mf(@Query("url") String url, @Query("user_id") String user_id);

    @POST("?url=mf_store")
    Call<MFSaveDTO> mfSave(@Body MFListBody body);

    @GET(BASE_URL)
    Call<List<GroupOnDTO>> showGroup(@Query("url") String url, @Query("user_id") String user_id);

    @GET(BASE_URL)
    Call<NotificationListDTO> notification(@Query("url") String url, @Query("limit") String limit, @Query("user_id") String user_id);

    //Api calls from Begali
    @GET(BASE_URL)
    Call<MainRequest> mainRequest();

    @GET(BASE_URL)
    Call<Product> getProduct(@Query("url") String path);

    @GET(BASE_URL)
    Call<ProductConfig> getProductConfig(@Query("url") String mPath);
    @GET(BASE_URL)
    Call<OtherProductsOfSeller> getOtherProductsOfSeller(@Query("url") String sellerProductUrl);
}
