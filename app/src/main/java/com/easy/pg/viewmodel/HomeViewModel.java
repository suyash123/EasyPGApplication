package com.easy.pg.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayMap;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.easy.pg.app.R;
import com.easy.pg.model.PGSearchInfo;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel{

    private MutableLiveData<ArrayList<PGSearchInfo>> mutableLiveData = new MutableLiveData<>();
    public ObservableArrayMap<String, String> images = new ObservableArrayMap<>();

    public HomeViewModel() {
    }

    public MutableLiveData<ArrayList<PGSearchInfo>> getMutableLiveData() {
        mutableLiveData.setValue(getSampleList());
        return mutableLiveData;
    }

    public void onReserveClick(Integer index){
        Log.d("HomeViewModel", "Reserve clicked >>>>>>>>>");
    }

    public PGSearchInfo getPGSearchInfoAt(Integer index) {
        Log.d("HomeViewModel", "getPGSearchInfoAt >>>>>>>>>");
        if(mutableLiveData != null) {
            PGSearchInfo pgSearchInfo = mutableLiveData.getValue().get(index);
            Log.d("HomeViewModel", "Search info :::: > " + pgSearchInfo.toString());
        }
        return null;
    }

    @BindingAdapter("imageUrl")
    public static void bindRecyclerViewAdapter(ImageView imageView, String imageUrl) {
        if (imageUrl != null) {
            // If we don't do this, you'll see the old image appear briefly
            // before it's replaced with the current image
            if (imageView.getTag(R.id.image_url) == null || !imageView.getTag(R.id.image_url).equals(imageUrl)) {
                imageView.setImageBitmap(null);
                imageView.setTag(R.id.image_url, imageUrl);
                Glide.with(imageView).load(imageUrl).into(imageView);
            }
        } else {
            imageView.setTag(R.id.image_url, null);
            imageView.setImageBitmap(null);
        }
    }

    private ArrayList<PGSearchInfo> getSampleList(){
        ArrayList<PGSearchInfo> pgSearchInfos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PGSearchInfo searchInfo = new PGSearchInfo("Twin Bed Room", "PSIR, Chandigadh", "24-B, Room-102, 2nd Floor", "Furnished room, Good Ambience", "Rs 1200", "within 1 Km");
            if(i==0){
                searchInfo.setCoverImgUrl("https://www.czech-inn.com/wp-content/uploads/2018/08/czech_inn_hostel_prague_16_bed_dorm_room_3_380x213.jpg");
            }
            if(i==1){
                searchInfo = new PGSearchInfo("Twin Bed Room", "IIT, Delhi", "24-B, Room-102, 2nd Floor", "Semi Furnished room, Best place for study", "Rs 1000", "within 1.5 Km");
                searchInfo.setCoverImgUrl("http://ccd.hwstatic.com/propertyimages/2/272919/3.jpg");
            }
            if(i==2){
                searchInfo = new PGSearchInfo("Single Bed Room", "IMT, Gaziabaad", "24-B, Room-102, 2nd Floor", "Furnished room, Good Locality", "Rs 1399", "within 2 Km");
                searchInfo.setCoverImgUrl("https://www.czech-inn.com/wp-content/uploads/2018/08/czech_inn_hostel_prague_premium_mixed_dorm_950x500-1300x698_c.jpg");
            }
            if(i==3){
                searchInfo = new PGSearchInfo("Single Bed Room", "VIT, Vellore", "24-B, Room-102, 2nd Floor", "Furnished room, Good Location", "Rs 2000", "within 5 Km");
                searchInfo.setCoverImgUrl("https://image.flyin.com/f/500x330,q85/http://images.flyin.com/ebtranet-images/117406/CZ506963%20(2).jpg");
            }
            if(i==4){
                searchInfo = new PGSearchInfo("Single Bed Room", "IIT, Kanpur", "24-B, Room-102, 2nd Floor", "Full Furnished room, Good Security", "Rs 3500", "within 4 Km");
                searchInfo.setCoverImgUrl("http://mangotreehostel.com/wp-content/uploads/2017/07/mango-tree-hostel-rio-de-janeiro-quadruple-deluxe-private-ensuite-5.jpg");
            }
            pgSearchInfos.add(searchInfo);
        }
        return pgSearchInfos;
    }
}
