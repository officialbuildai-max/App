package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.view.Lifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final String f9449a;

    /* renamed from: b, reason: collision with root package name */
    final String f9450b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f9451c;

    /* renamed from: d, reason: collision with root package name */
    final int f9452d;

    /* renamed from: e, reason: collision with root package name */
    final int f9453e;

    /* renamed from: f, reason: collision with root package name */
    final String f9454f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f9455g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f9456h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f9457i;

    /* renamed from: j, reason: collision with root package name */
    final Bundle f9458j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f9459k;

    /* renamed from: l, reason: collision with root package name */
    final int f9460l;

    /* renamed from: m, reason: collision with root package name */
    Bundle f9461m;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i11) {
            return new FragmentState[i11];
        }
    }

    FragmentState(Parcel parcel) {
        this.f9449a = parcel.readString();
        this.f9450b = parcel.readString();
        this.f9451c = parcel.readInt() != 0;
        this.f9452d = parcel.readInt();
        this.f9453e = parcel.readInt();
        this.f9454f = parcel.readString();
        this.f9455g = parcel.readInt() != 0;
        this.f9456h = parcel.readInt() != 0;
        this.f9457i = parcel.readInt() != 0;
        this.f9458j = parcel.readBundle();
        this.f9459k = parcel.readInt() != 0;
        this.f9461m = parcel.readBundle();
        this.f9460l = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentState(Fragment fragment) {
        this.f9449a = fragment.getClass().getName();
        this.f9450b = fragment.mWho;
        this.f9451c = fragment.mFromLayout;
        this.f9452d = fragment.mFragmentId;
        this.f9453e = fragment.mContainerId;
        this.f9454f = fragment.mTag;
        this.f9455g = fragment.mRetainInstance;
        this.f9456h = fragment.mRemoving;
        this.f9457i = fragment.mDetached;
        this.f9458j = fragment.mArguments;
        this.f9459k = fragment.mHidden;
        this.f9460l = fragment.mMaxState.ordinal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a(h hVar, ClassLoader classLoader) {
        Fragment instantiate = hVar.instantiate(classLoader, this.f9449a);
        Bundle bundle = this.f9458j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        instantiate.setArguments(this.f9458j);
        instantiate.mWho = this.f9450b;
        instantiate.mFromLayout = this.f9451c;
        instantiate.mRestored = true;
        instantiate.mFragmentId = this.f9452d;
        instantiate.mContainerId = this.f9453e;
        instantiate.mTag = this.f9454f;
        instantiate.mRetainInstance = this.f9455g;
        instantiate.mRemoving = this.f9456h;
        instantiate.mDetached = this.f9457i;
        instantiate.mHidden = this.f9459k;
        instantiate.mMaxState = Lifecycle.State.values()[this.f9460l];
        Bundle bundle2 = this.f9461m;
        if (bundle2 != null) {
            instantiate.mSavedFragmentState = bundle2;
        } else {
            instantiate.mSavedFragmentState = new Bundle();
        }
        return instantiate;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f9449a);
        sb2.append(" (");
        sb2.append(this.f9450b);
        sb2.append(")}:");
        if (this.f9451c) {
            sb2.append(" fromLayout");
        }
        if (this.f9453e != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f9453e));
        }
        String str = this.f9454f;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.f9454f);
        }
        if (this.f9455g) {
            sb2.append(" retainInstance");
        }
        if (this.f9456h) {
            sb2.append(" removing");
        }
        if (this.f9457i) {
            sb2.append(" detached");
        }
        if (this.f9459k) {
            sb2.append(" hidden");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f9449a);
        parcel.writeString(this.f9450b);
        parcel.writeInt(this.f9451c ? 1 : 0);
        parcel.writeInt(this.f9452d);
        parcel.writeInt(this.f9453e);
        parcel.writeString(this.f9454f);
        parcel.writeInt(this.f9455g ? 1 : 0);
        parcel.writeInt(this.f9456h ? 1 : 0);
        parcel.writeInt(this.f9457i ? 1 : 0);
        parcel.writeBundle(this.f9458j);
        parcel.writeInt(this.f9459k ? 1 : 0);
        parcel.writeBundle(this.f9461m);
        parcel.writeInt(this.f9460l);
    }
}
