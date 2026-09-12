package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;

/* loaded from: classes2.dex */
class b extends VersionedParcel {

    /* renamed from: d, reason: collision with root package name */
    private final SparseIntArray f15305d;

    /* renamed from: e, reason: collision with root package name */
    private final Parcel f15306e;

    /* renamed from: f, reason: collision with root package name */
    private final int f15307f;

    /* renamed from: g, reason: collision with root package name */
    private final int f15308g;

    /* renamed from: h, reason: collision with root package name */
    private final String f15309h;

    /* renamed from: i, reason: collision with root package name */
    private int f15310i;

    /* renamed from: j, reason: collision with root package name */
    private int f15311j;

    /* renamed from: k, reason: collision with root package name */
    private int f15312k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.collection.a(), new androidx.collection.a(), new androidx.collection.a());
    }

    private b(Parcel parcel, int i11, int i12, String str, androidx.collection.a aVar, androidx.collection.a aVar2, androidx.collection.a aVar3) {
        super(aVar, aVar2, aVar3);
        this.f15305d = new SparseIntArray();
        this.f15310i = -1;
        this.f15312k = -1;
        this.f15306e = parcel;
        this.f15307f = i11;
        this.f15308g = i12;
        this.f15311j = i11;
        this.f15309h = str;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f15306e.writeInt(-1);
        } else {
            this.f15306e.writeInt(bArr.length);
            this.f15306e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f15306e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void E(int i11) {
        this.f15306e.writeInt(i11);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void G(Parcelable parcelable) {
        this.f15306e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void I(String str) {
        this.f15306e.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        int i11 = this.f15310i;
        if (i11 >= 0) {
            int i12 = this.f15305d.get(i11);
            int dataPosition = this.f15306e.dataPosition();
            this.f15306e.setDataPosition(i12);
            this.f15306e.writeInt(dataPosition - i12);
            this.f15306e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel b() {
        Parcel parcel = this.f15306e;
        int dataPosition = parcel.dataPosition();
        int i11 = this.f15311j;
        if (i11 == this.f15307f) {
            i11 = this.f15308g;
        }
        return new b(parcel, dataPosition, i11, this.f15309h + "  ", this.f15302a, this.f15303b, this.f15304c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean g() {
        return this.f15306e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] i() {
        int readInt = this.f15306e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f15306e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f15306e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean m(int i11) {
        while (this.f15311j < this.f15308g) {
            int i12 = this.f15312k;
            if (i12 == i11) {
                return true;
            }
            if (String.valueOf(i12).compareTo(String.valueOf(i11)) > 0) {
                return false;
            }
            this.f15306e.setDataPosition(this.f15311j);
            int readInt = this.f15306e.readInt();
            this.f15312k = this.f15306e.readInt();
            this.f15311j += readInt;
        }
        return this.f15312k == i11;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int o() {
        return this.f15306e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Parcelable q() {
        return this.f15306e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String s() {
        return this.f15306e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void w(int i11) {
        a();
        this.f15310i = i11;
        this.f15305d.put(i11, this.f15306e.dataPosition());
        E(0);
        E(i11);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void y(boolean z10) {
        this.f15306e.writeInt(z10 ? 1 : 0);
    }
}
