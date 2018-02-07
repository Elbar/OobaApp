package com.kg.vista.ooba.api;

import com.kg.vista.ooba.model.Catalog;
import com.kg.vista.ooba.model.CollectionGood;
import com.kg.vista.ooba.model.Discount;
import com.kg.vista.ooba.model.MainRequest;
import com.kg.vista.ooba.model.OtherProductsOfSeller;
import com.kg.vista.ooba.model.Product;
import com.kg.vista.ooba.model.ProductConfig;
import com.kg.vista.ooba.model.ProductDetail;
import com.kg.vista.ooba.model.ProductList;
import com.kg.vista.ooba.model.PublicGood;
import com.kg.vista.ooba.model.WhatsNew;
import com.kg.vista.ooba.model.body.LoginBody;
import com.kg.vista.ooba.model.body.MFListBody;
import com.kg.vista.ooba.model.body.RegistrationBody;
import com.kg.vista.ooba.model.dto.AddAddressDTO;
import com.kg.vista.ooba.model.dto.AddressDTO;
import com.kg.vista.ooba.model.dto.BalanceDTO;
import com.kg.vista.ooba.model.dto.BasketListDTO;
import com.kg.vista.ooba.model.dto.ClearBasketDTO;
import com.kg.vista.ooba.model.dto.DeleteAddressDTO;
import com.kg.vista.ooba.model.dto.DeleteGoodDTO;
import com.kg.vista.ooba.model.dto.GroupOnDTO;
import com.kg.vista.ooba.model.dto.LoginDTO;
import com.kg.vista.ooba.model.dto.MFListDTO;
import com.kg.vista.ooba.model.dto.MFSaveDTO;
import com.kg.vista.ooba.model.dto.NotificationListDTO;
import com.kg.vista.ooba.model.dto.OrderGoodDTO;
import com.kg.vista.ooba.model.dto.PartnerListDTO;
import com.kg.vista.ooba.model.dto.PaymentsListDTO;
import com.kg.vista.ooba.model.dto.PaymentsStatusDTO;
import com.kg.vista.ooba.model.dto.RegistrationDTO;
import com.kg.vista.ooba.model.dto.SecurityDTO;
import com.kg.vista.ooba.model.dto.UpdateAddressDTO;
import com.kg.vista.ooba.model.dto.UpdateDataDTO;
import com.kg.vista.ooba.model.dto.UpdateGoodDTO;
import com.kg.vista.ooba.model.dto.UserListDTO;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static com.kg.vista.ooba.api.conf.Config.BASE_URL;


public interface RetrofitService {

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

    @GET(BASE_URL)
    Call<MainRequest> mainRequest();

    @GET(BASE_URL)
    Call<Product> getProduct(@Query("url") String path);

    @GET(BASE_URL)
    Call<ProductConfig> getProductConfig(@Query("url") String mPath);

    @GET(BASE_URL)
    Call<OtherProductsOfSeller> getOtherProductsOfSeller(@Query("url") String sellerProductUrl);

    @GET(BASE_URL + "?url=mixed&filter=all&limit=6")
    Call<List<WhatsNew>> getWhatsAllItems();

    @GET(BASE_URL + "?url=mixed&filter=all&limit=6")
    Call<List<WhatsNew>> getWhatsPopularItems();

    @GET(BASE_URL + "?url=mixed&filter=all&limit=6")
    Call<List<WhatsNew>> getWhatsNewItems();

    @GET(BASE_URL + "?url=mixed&filter=blogs&limit=6")
    Call<List<WhatsNew>> getBlogs();

    @GET(BASE_URL + "?url=catalog")
    Call<List<Catalog>> getCatalog();

    @GET(BASE_URL + "?url=catalog/tmall")
    Call<ResponseBody> getShopByIndex();

    @GET(BASE_URL + "?url=catalog/tmall/28")
    Call<ProductList> getProductByIndex();

    @GET(BASE_URL)
    Call<ProductDetail> getDetailOfProduct(@Query("url") String urlProduct);

    @GET("http://api.ooba.kg/?url=groupon&limit=8&start=0")
    Call<List<Discount>> getDiscountGoods();

    @GET("http://api.ooba.kg/?url=collection&limit=6&start=0")
    Call<List<CollectionGood>> getCollectionGoods();

    @GET("http://api.ooba.kg/?url=public&limit=8&start=0")
    Call<List<PublicGood>> getPublicGoods();



}
