package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final List f9310a;

    /* renamed from: b, reason: collision with root package name */
    final List f9311b;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackState[] newArray(int i11) {
            return new BackStackState[i11];
        }
    }

    BackStackState(Parcel parcel) {
        this.f9310a = parcel.createStringArrayList();
        this.f9311b = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackStackState(List list, List list2) {
        this.f9310a = list;
        this.f9311b = list2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List a(FragmentManager fragmentManager, Map map) {
        HashMap hashMap = new HashMap(this.f9310a.size());
        for (String str : this.f9310a) {
            Fragment fragment = (Fragment) map.get(str);
            if (fragment != null) {
                hashMap.put(fragment.mWho, fragment);
            } else {
                FragmentState B = fragmentManager.x0().B(str, null);
                if (B != null) {
                    Fragment a11 = B.a(fragmentManager.w0(), fragmentManager.z0().f().getClassLoader());
                    hashMap.put(a11.mWho, a11);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f9311b.iterator();
        while (it.hasNext()) {
            arrayList.add(((BackStackRecordState) it.next()).c(fragmentManager, hashMap));
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeStringList(this.f9310a);
        parcel.writeTypedList(this.f9311b);
    }
}
