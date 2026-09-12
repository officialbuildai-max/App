package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    ArrayList f9441a;

    /* renamed from: b, reason: collision with root package name */
    ArrayList f9442b;

    /* renamed from: c, reason: collision with root package name */
    BackStackRecordState[] f9443c;

    /* renamed from: d, reason: collision with root package name */
    int f9444d;

    /* renamed from: e, reason: collision with root package name */
    String f9445e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList f9446f;

    /* renamed from: g, reason: collision with root package name */
    ArrayList f9447g;

    /* renamed from: h, reason: collision with root package name */
    ArrayList f9448h;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState[] newArray(int i11) {
            return new FragmentManagerState[i11];
        }
    }

    public FragmentManagerState() {
        this.f9445e = null;
        this.f9446f = new ArrayList();
        this.f9447g = new ArrayList();
    }

    public FragmentManagerState(Parcel parcel) {
        this.f9445e = null;
        this.f9446f = new ArrayList();
        this.f9447g = new ArrayList();
        this.f9441a = parcel.createStringArrayList();
        this.f9442b = parcel.createStringArrayList();
        this.f9443c = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
        this.f9444d = parcel.readInt();
        this.f9445e = parcel.readString();
        this.f9446f = parcel.createStringArrayList();
        this.f9447g = parcel.createTypedArrayList(BackStackState.CREATOR);
        this.f9448h = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeStringList(this.f9441a);
        parcel.writeStringList(this.f9442b);
        parcel.writeTypedArray(this.f9443c, i11);
        parcel.writeInt(this.f9444d);
        parcel.writeString(this.f9445e);
        parcel.writeStringList(this.f9446f);
        parcel.writeTypedList(this.f9447g);
        parcel.writeTypedList(this.f9448h);
    }
}
