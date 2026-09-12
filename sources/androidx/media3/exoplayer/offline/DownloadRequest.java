package androidx.media3.exoplayer.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.StreamKey;
import androidx.media3.common.t;
import androidx.media3.common.util.a1;
import androidx.media3.common.y;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new a();

    @Nullable
    public final ByteRange byteRange;

    @Nullable
    public final String customCacheKey;
    public final byte[] data;

    /* renamed from: id, reason: collision with root package name */
    public final String f12425id;

    @Nullable
    public final byte[] keySetId;

    @Nullable
    public final String mimeType;
    public final List<StreamKey> streamKeys;
    public final Uri uri;

    /* loaded from: classes2.dex */
    public static final class ByteRange implements Parcelable {
        public static final Parcelable.Creator<ByteRange> CREATOR = new a();
        public final long length;
        public final long offset;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ByteRange createFromParcel(Parcel parcel) {
                return new ByteRange(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ByteRange[] newArray(int i11) {
                return new ByteRange[i11];
            }
        }

        ByteRange(long j11, long j12) {
            androidx.media3.common.util.a.a(j11 >= 0);
            androidx.media3.common.util.a.a(j12 >= 0 || j12 == -1);
            this.offset = j11;
            this.length = j12;
        }

        ByteRange(Parcel parcel) {
            this(parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof ByteRange)) {
                return false;
            }
            ByteRange byteRange = (ByteRange) obj;
            return this.offset == byteRange.offset && this.length == byteRange.length;
        }

        public int hashCode() {
            return (((int) this.offset) * 961) + ((int) this.length);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeLong(this.offset);
            parcel.writeLong(this.length);
        }
    }

    /* loaded from: classes2.dex */
    public static class UnsupportedRequestException extends IOException {
    }

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DownloadRequest[] newArray(int i11) {
            return new DownloadRequest[i11];
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f12426a;

        /* renamed from: b, reason: collision with root package name */
        private final Uri f12427b;

        /* renamed from: c, reason: collision with root package name */
        private String f12428c;

        /* renamed from: d, reason: collision with root package name */
        private List f12429d;

        /* renamed from: e, reason: collision with root package name */
        private byte[] f12430e;

        /* renamed from: f, reason: collision with root package name */
        private String f12431f;

        /* renamed from: g, reason: collision with root package name */
        private byte[] f12432g;

        /* renamed from: h, reason: collision with root package name */
        private ByteRange f12433h = null;

        public b(String str, Uri uri) {
            this.f12426a = str;
            this.f12427b = uri;
        }

        public DownloadRequest a() {
            String str = this.f12426a;
            Uri uri = this.f12427b;
            String str2 = this.f12428c;
            List list = this.f12429d;
            if (list == null) {
                list = ImmutableList.of();
            }
            return new DownloadRequest(str, uri, str2, list, this.f12430e, this.f12431f, this.f12432g, this.f12433h, null);
        }

        public b b(String str) {
            this.f12431f = str;
            return this;
        }

        public b c(byte[] bArr) {
            this.f12432g = bArr;
            return this;
        }

        public b d(byte[] bArr) {
            this.f12430e = bArr;
            return this;
        }

        public b e(String str) {
            this.f12428c = y.u(str);
            return this;
        }

        public b f(List list) {
            this.f12429d = list;
            return this;
        }
    }

    DownloadRequest(Parcel parcel) {
        this.f12425id = (String) a1.i(parcel.readString());
        this.uri = Uri.parse((String) a1.i(parcel.readString()));
        this.mimeType = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i11 = 0; i11 < readInt; i11++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.keySetId = parcel.createByteArray();
        this.customCacheKey = parcel.readString();
        this.data = (byte[]) a1.i(parcel.createByteArray());
        this.byteRange = (ByteRange) parcel.readParcelable(ByteRange.class.getClassLoader());
    }

    private DownloadRequest(String str, Uri uri, @Nullable String str2, List<StreamKey> list, @Nullable byte[] bArr, @Nullable String str3, @Nullable byte[] bArr2, @Nullable ByteRange byteRange) {
        int A0 = a1.A0(uri, str2);
        if (A0 == 0 || A0 == 2 || A0 == 1) {
            androidx.media3.common.util.a.b(str3 == null, "customCacheKey must be null for type: " + A0);
            this.byteRange = null;
        } else {
            this.byteRange = byteRange;
        }
        this.f12425id = str;
        this.uri = uri;
        this.mimeType = str2;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.keySetId = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        this.customCacheKey = str3;
        this.data = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : a1.f10437f;
    }

    /* synthetic */ DownloadRequest(String str, Uri uri, String str2, List list, byte[] bArr, String str3, byte[] bArr2, ByteRange byteRange, a aVar) {
        this(str, uri, str2, list, bArr, str3, bArr2, byteRange);
    }

    public DownloadRequest copyWithId(String str) {
        return new DownloadRequest(str, this.uri, this.mimeType, this.streamKeys, this.keySetId, this.customCacheKey, this.data, this.byteRange);
    }

    public DownloadRequest copyWithKeySetId(@Nullable byte[] bArr) {
        return new DownloadRequest(this.f12425id, this.uri, this.mimeType, this.streamKeys, bArr, this.customCacheKey, this.data, this.byteRange);
    }

    public DownloadRequest copyWithMergedRequest(DownloadRequest downloadRequest) {
        List emptyList;
        androidx.media3.common.util.a.a(this.f12425id.equals(downloadRequest.f12425id));
        if (this.streamKeys.isEmpty() || downloadRequest.streamKeys.isEmpty()) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = new ArrayList(this.streamKeys);
            for (int i11 = 0; i11 < downloadRequest.streamKeys.size(); i11++) {
                StreamKey streamKey = downloadRequest.streamKeys.get(i11);
                if (!emptyList.contains(streamKey)) {
                    emptyList.add(streamKey);
                }
            }
        }
        return new DownloadRequest(this.f12425id, downloadRequest.uri, downloadRequest.mimeType, emptyList, downloadRequest.keySetId, downloadRequest.customCacheKey, downloadRequest.data, downloadRequest.byteRange);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return this.f12425id.equals(downloadRequest.f12425id) && this.uri.equals(downloadRequest.uri) && Objects.equals(this.mimeType, downloadRequest.mimeType) && this.streamKeys.equals(downloadRequest.streamKeys) && Arrays.equals(this.keySetId, downloadRequest.keySetId) && Objects.equals(this.customCacheKey, downloadRequest.customCacheKey) && Arrays.equals(this.data, downloadRequest.data) && Objects.equals(this.byteRange, downloadRequest.byteRange);
    }

    public int hashCode() {
        int hashCode = ((this.f12425id.hashCode() * 961) + this.uri.hashCode()) * 31;
        String str = this.mimeType;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.streamKeys.hashCode()) * 31) + Arrays.hashCode(this.keySetId)) * 31;
        String str2 = this.customCacheKey;
        int hashCode3 = (((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.data)) * 31;
        ByteRange byteRange = this.byteRange;
        return hashCode3 + (byteRange != null ? byteRange.hashCode() : 0);
    }

    public androidx.media3.common.t toMediaItem() {
        return new t.c().d(this.f12425id).i(this.uri).b(this.customCacheKey).e(this.mimeType).f(this.streamKeys).a();
    }

    public String toString() {
        return this.mimeType + ":" + this.f12425id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f12425id);
        parcel.writeString(this.uri.toString());
        parcel.writeString(this.mimeType);
        parcel.writeInt(this.streamKeys.size());
        for (int i12 = 0; i12 < this.streamKeys.size(); i12++) {
            parcel.writeParcelable(this.streamKeys.get(i12), 0);
        }
        parcel.writeByteArray(this.keySetId);
        parcel.writeString(this.customCacheKey);
        parcel.writeByteArray(this.data);
        parcel.writeParcelable(this.byteRange, 0);
    }
}
