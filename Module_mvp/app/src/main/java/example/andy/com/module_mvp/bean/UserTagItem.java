package example.andy.com.module_mvp.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chenjianwei on 16/5/10.
 */
public class UserTagItem implements Parcelable {
    public int id;
    public String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserTagItem(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable's
     * marshalled representation.
     *
     * @return a bitmask indicating the set of special object types marshalled
     * by the Parcelable.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    public static final Parcelable.Creator<UserTagItem> CREATOR = new Creator<UserTagItem>() {
        @Override
        public UserTagItem createFromParcel(Parcel source) {
            return new UserTagItem(source);
        }

        @Override
        public UserTagItem[] newArray(int size) {
            return new UserTagItem[size];
        }
    };

    public UserTagItem(Parcel source){
        id = source.readInt();
        name = source.readString();
    }

}
