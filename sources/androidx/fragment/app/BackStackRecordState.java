package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.w;
import androidx.view.Lifecycle;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new a();
    private static final String TAG = "FragmentManager";

    /* renamed from: a, reason: collision with root package name */
    final int[] f9296a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList f9297b;

    /* renamed from: c, reason: collision with root package name */
    final int[] f9298c;

    /* renamed from: d, reason: collision with root package name */
    final int[] f9299d;

    /* renamed from: e, reason: collision with root package name */
    final int f9300e;

    /* renamed from: f, reason: collision with root package name */
    final String f9301f;

    /* renamed from: g, reason: collision with root package name */
    final int f9302g;

    /* renamed from: h, reason: collision with root package name */
    final int f9303h;

    /* renamed from: i, reason: collision with root package name */
    final CharSequence f9304i;

    /* renamed from: j, reason: collision with root package name */
    final int f9305j;

    /* renamed from: k, reason: collision with root package name */
    final CharSequence f9306k;

    /* renamed from: l, reason: collision with root package name */
    final ArrayList f9307l;

    /* renamed from: m, reason: collision with root package name */
    final ArrayList f9308m;

    /* renamed from: n, reason: collision with root package name */
    final boolean f9309n;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState[] newArray(int i11) {
            return new BackStackRecordState[i11];
        }
    }

    BackStackRecordState(Parcel parcel) {
        this.f9296a = parcel.createIntArray();
        this.f9297b = parcel.createStringArrayList();
        this.f9298c = parcel.createIntArray();
        this.f9299d = parcel.createIntArray();
        this.f9300e = parcel.readInt();
        this.f9301f = parcel.readString();
        this.f9302g = parcel.readInt();
        this.f9303h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f9304i = (CharSequence) creator.createFromParcel(parcel);
        this.f9305j = parcel.readInt();
        this.f9306k = (CharSequence) creator.createFromParcel(parcel);
        this.f9307l = parcel.createStringArrayList();
        this.f9308m = parcel.createStringArrayList();
        this.f9309n = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackStackRecordState(androidx.fragment.app.a aVar) {
        int size = aVar.f9560c.size();
        this.f9296a = new int[size * 6];
        if (!aVar.f9566i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f9297b = new ArrayList(size);
        this.f9298c = new int[size];
        this.f9299d = new int[size];
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            w.a aVar2 = (w.a) aVar.f9560c.get(i12);
            int i13 = i11 + 1;
            this.f9296a[i11] = aVar2.f9577a;
            ArrayList arrayList = this.f9297b;
            Fragment fragment = aVar2.f9578b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f9296a;
            iArr[i13] = aVar2.f9579c ? 1 : 0;
            iArr[i11 + 2] = aVar2.f9580d;
            iArr[i11 + 3] = aVar2.f9581e;
            int i14 = i11 + 5;
            iArr[i11 + 4] = aVar2.f9582f;
            i11 += 6;
            iArr[i14] = aVar2.f9583g;
            this.f9298c[i12] = aVar2.f9584h.ordinal();
            this.f9299d[i12] = aVar2.f9585i.ordinal();
        }
        this.f9300e = aVar.f9565h;
        this.f9301f = aVar.f9568k;
        this.f9302g = aVar.f9506v;
        this.f9303h = aVar.f9569l;
        this.f9304i = aVar.f9570m;
        this.f9305j = aVar.f9571n;
        this.f9306k = aVar.f9572o;
        this.f9307l = aVar.f9573p;
        this.f9308m = aVar.f9574q;
        this.f9309n = aVar.f9575r;
    }

    private void a(androidx.fragment.app.a aVar) {
        int i11 = 0;
        int i12 = 0;
        while (true) {
            boolean z10 = true;
            if (i11 >= this.f9296a.length) {
                aVar.f9565h = this.f9300e;
                aVar.f9568k = this.f9301f;
                aVar.f9566i = true;
                aVar.f9569l = this.f9303h;
                aVar.f9570m = this.f9304i;
                aVar.f9571n = this.f9305j;
                aVar.f9572o = this.f9306k;
                aVar.f9573p = this.f9307l;
                aVar.f9574q = this.f9308m;
                aVar.f9575r = this.f9309n;
                return;
            }
            w.a aVar2 = new w.a();
            int i13 = i11 + 1;
            aVar2.f9577a = this.f9296a[i11];
            if (FragmentManager.M0(2)) {
                Log.v(TAG, "Instantiate " + aVar + " op #" + i12 + " base fragment #" + this.f9296a[i13]);
            }
            aVar2.f9584h = Lifecycle.State.values()[this.f9298c[i12]];
            aVar2.f9585i = Lifecycle.State.values()[this.f9299d[i12]];
            int[] iArr = this.f9296a;
            int i14 = i11 + 2;
            if (iArr[i13] == 0) {
                z10 = false;
            }
            aVar2.f9579c = z10;
            int i15 = iArr[i14];
            aVar2.f9580d = i15;
            int i16 = iArr[i11 + 3];
            aVar2.f9581e = i16;
            int i17 = i11 + 5;
            int i18 = iArr[i11 + 4];
            aVar2.f9582f = i18;
            i11 += 6;
            int i19 = iArr[i17];
            aVar2.f9583g = i19;
            aVar.f9561d = i15;
            aVar.f9562e = i16;
            aVar.f9563f = i18;
            aVar.f9564g = i19;
            aVar.f(aVar2);
            i12++;
        }
    }

    public androidx.fragment.app.a b(FragmentManager fragmentManager) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        a(aVar);
        aVar.f9506v = this.f9302g;
        for (int i11 = 0; i11 < this.f9297b.size(); i11++) {
            String str = (String) this.f9297b.get(i11);
            if (str != null) {
                ((w.a) aVar.f9560c.get(i11)).f9578b = fragmentManager.h0(str);
            }
        }
        aVar.z(1);
        return aVar;
    }

    public androidx.fragment.app.a c(FragmentManager fragmentManager, Map map) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        a(aVar);
        for (int i11 = 0; i11 < this.f9297b.size(); i11++) {
            String str = (String) this.f9297b.get(i11);
            if (str != null) {
                Fragment fragment = (Fragment) map.get(str);
                if (fragment == null) {
                    throw new IllegalStateException("Restoring FragmentTransaction " + this.f9301f + " failed due to missing saved state for Fragment (" + str + ")");
                }
                ((w.a) aVar.f9560c.get(i11)).f9578b = fragment;
            }
        }
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeIntArray(this.f9296a);
        parcel.writeStringList(this.f9297b);
        parcel.writeIntArray(this.f9298c);
        parcel.writeIntArray(this.f9299d);
        parcel.writeInt(this.f9300e);
        parcel.writeString(this.f9301f);
        parcel.writeInt(this.f9302g);
        parcel.writeInt(this.f9303h);
        TextUtils.writeToParcel(this.f9304i, parcel, 0);
        parcel.writeInt(this.f9305j);
        TextUtils.writeToParcel(this.f9306k, parcel, 0);
        parcel.writeStringList(this.f9307l);
        parcel.writeStringList(this.f9308m);
        parcel.writeInt(this.f9309n ? 1 : 0);
    }
}
