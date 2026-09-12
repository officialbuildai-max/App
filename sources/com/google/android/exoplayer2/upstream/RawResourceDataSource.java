package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.p0;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* loaded from: classes3.dex */
public final class RawResourceDataSource extends f {

    /* renamed from: e, reason: collision with root package name */
    private final Resources f27307e;

    /* renamed from: f, reason: collision with root package name */
    private final String f27308f;

    /* renamed from: g, reason: collision with root package name */
    private Uri f27309g;

    /* renamed from: h, reason: collision with root package name */
    private AssetFileDescriptor f27310h;

    /* renamed from: i, reason: collision with root package name */
    private InputStream f27311i;

    /* renamed from: j, reason: collision with root package name */
    private long f27312j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f27313k;

    /* loaded from: classes3.dex */
    public static class RawResourceDataSourceException extends DataSourceException {
        @Deprecated
        public RawResourceDataSourceException(String str) {
            super(str, null, 2000);
        }

        public RawResourceDataSourceException(@Nullable String str, @Nullable Throwable th2, int i11) {
            super(str, th2, i11);
        }

        @Deprecated
        public RawResourceDataSourceException(Throwable th2) {
            super(th2, 2000);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f27307e = context.getResources();
        this.f27308f = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i11) {
        return Uri.parse("rawresource:///" + i11);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) {
        int parseInt;
        String str;
        Uri uri = nVar.f27491a;
        this.f27309g = uri;
        if (TextUtils.equals(com.mbridge.msdk.playercommon.exoplayer2.upstream.RawResourceDataSource.RAW_RESOURCE_SCHEME, uri.getScheme()) || (TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) com.google.android.exoplayer2.util.a.e(uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, 1004);
            }
        } else {
            if (!TextUtils.equals("android.resource", uri.getScheme())) {
                throw new RawResourceDataSourceException("URI must either use scheme rawresource or android.resource", null, 1004);
            }
            String str2 = (String) com.google.android.exoplayer2.util.a.e(uri.getPath());
            if (str2.startsWith("/")) {
                str2 = str2.substring(1);
            }
            String host = uri.getHost();
            StringBuilder sb2 = new StringBuilder();
            if (TextUtils.isEmpty(host)) {
                str = "";
            } else {
                str = host + ":";
            }
            sb2.append(str);
            sb2.append(str2);
            parseInt = this.f27307e.getIdentifier(sb2.toString(), "raw", this.f27308f);
            if (parseInt == 0) {
                throw new RawResourceDataSourceException("Resource not found.", null, 2005);
            }
        }
        j(nVar);
        try {
            AssetFileDescriptor openRawResourceFd = this.f27307e.openRawResourceFd(parseInt);
            this.f27310h = openRawResourceFd;
            if (openRawResourceFd == null) {
                throw new RawResourceDataSourceException("Resource is compressed: " + uri, null, 2000);
            }
            long length = openRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
            this.f27311i = fileInputStream;
            if (length != -1) {
                try {
                    if (nVar.f27497g > length) {
                        throw new RawResourceDataSourceException(null, null, 2008);
                    }
                } catch (RawResourceDataSourceException e11) {
                    throw e11;
                } catch (IOException e12) {
                    throw new RawResourceDataSourceException(null, e12, 2000);
                }
            }
            long startOffset = openRawResourceFd.getStartOffset();
            long skip = fileInputStream.skip(nVar.f27497g + startOffset) - startOffset;
            if (skip != nVar.f27497g) {
                throw new RawResourceDataSourceException(null, null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                if (channel.size() == 0) {
                    this.f27312j = -1L;
                } else {
                    long size = channel.size() - channel.position();
                    this.f27312j = size;
                    if (size < 0) {
                        throw new RawResourceDataSourceException(null, null, 2008);
                    }
                }
            } else {
                long j11 = length - skip;
                this.f27312j = j11;
                if (j11 < 0) {
                    throw new DataSourceException(2008);
                }
            }
            long j12 = nVar.f27498h;
            if (j12 != -1) {
                long j13 = this.f27312j;
                if (j13 != -1) {
                    j12 = Math.min(j13, j12);
                }
                this.f27312j = j12;
            }
            this.f27313k = true;
            k(nVar);
            long j14 = nVar.f27498h;
            return j14 != -1 ? j14 : this.f27312j;
        } catch (Resources.NotFoundException e13) {
            throw new RawResourceDataSourceException(null, e13, 2005);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        this.f27309g = null;
        try {
            try {
                InputStream inputStream = this.f27311i;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f27311i = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f27310h;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e11) {
                        throw new RawResourceDataSourceException(null, e11, 2000);
                    }
                } finally {
                    this.f27310h = null;
                    if (this.f27313k) {
                        this.f27313k = false;
                        i();
                    }
                }
            } catch (IOException e12) {
                throw new RawResourceDataSourceException(null, e12, 2000);
            }
        } catch (Throwable th2) {
            this.f27311i = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f27310h;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f27310h = null;
                    if (this.f27313k) {
                        this.f27313k = false;
                        i();
                    }
                    throw th2;
                } catch (IOException e13) {
                    throw new RawResourceDataSourceException(null, e13, 2000);
                }
            } finally {
                this.f27310h = null;
                if (this.f27313k) {
                    this.f27313k = false;
                    i();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Uri getUri() {
        return this.f27309g;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f27312j;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, i12);
            } catch (IOException e11) {
                throw new RawResourceDataSourceException(null, e11, 2000);
            }
        }
        int read = ((InputStream) p0.j(this.f27311i)).read(bArr, i11, i12);
        if (read == -1) {
            if (this.f27312j == -1) {
                return -1;
            }
            throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j12 = this.f27312j;
        if (j12 != -1) {
            this.f27312j = j12 - read;
        }
        h(read);
        return read;
    }
}
