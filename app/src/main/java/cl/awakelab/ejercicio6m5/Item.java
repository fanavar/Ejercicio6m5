package cl.awakelab.ejercicio6m5;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Item implements Parcelable {
    private String name;
    private String imageUrl;

    public Item(String name, String imageUrl){
        this.name = name;
        this.imageUrl = imageUrl;
    }

    protected Item(Parcel in){
        name = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getName(){
        return name;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(imageUrl);
    }
}
