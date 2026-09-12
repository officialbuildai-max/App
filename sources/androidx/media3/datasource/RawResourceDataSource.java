package androidx.media3.datasource;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.util.a1;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.List;
import w1.h;

/* loaded from: classes2.dex */
public final class RawResourceDataSource extends w1.a {

    /* renamed from: e, reason: collision with root package name */
    private final Context f10785e;

    /* renamed from: f, reason: collision with root package name */
    private h f10786f;

    /* renamed from: g, reason: collision with root package name */
    private AssetFileDescriptor f10787g;

    /* renamed from: h, reason: collision with root package name */
    private InputStream f10788h;

    /* renamed from: i, reason: collision with root package name */
    private long f10789i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f10790j;

    /* loaded from: classes2.dex */
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
        this.f10785e = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i11) {
        return Uri.parse("rawresource:///" + i11);
    }

    private static AssetFileDescriptor h(Context context, h hVar) {
        Resources resourcesForApplication;
        int identifier;
        Uri normalizeScheme = hVar.f77634a.normalizeScheme();
        if (TextUtils.equals(com.mbridge.msdk.playercommon.exoplayer2.upstream.RawResourceDataSource.RAW_RESOURCE_SCHEME, normalizeScheme.getScheme())) {
            resourcesForApplication = context.getResources();
            List<String> pathSegments = normalizeScheme.getPathSegments();
            if (pathSegments.size() != 1) {
                throw new RawResourceDataSourceException("rawresource:// URI must have exactly one path element, found " + pathSegments.size());
            }
            identifier = i(pathSegments.get(0));
        } else {
            if (!TextUtils.equals("android.resource", normalizeScheme.getScheme())) {
                throw new RawResourceDataSourceException("Unsupported URI scheme (" + normalizeScheme.getScheme() + "). Only android.resource is supported.", null, 1004);
            }
            String str = (String) androidx.media3.common.util.a.e(normalizeScheme.getPath());
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            String packageName = TextUtils.isEmpty(normalizeScheme.getHost()) ? context.getPackageName() : normalizeScheme.getHost();
            if (packageName.equals(context.getPackageName())) {
                resourcesForApplication = context.getResources();
            } else {
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(packageName);
                } catch (PackageManager.NameNotFoundException e11) {
                    throw new RawResourceDataSourceException("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e11, 2005);
                }
            }
            if (str.matches("\\d+")) {
                identifier = i(str);
            } else {
                identifier = resourcesForApplication.getIdentifier(packageName + ":" + str, "raw", null);
                if (identifier == 0) {
                    throw new RawResourceDataSourceException("Resource not found.", null, 2005);
                }
            }
        }
        try {
            AssetFileDescriptor openRawResourceFd = resourcesForApplication.openRawResourceFd(identifier);
            if (openRawResourceFd != null) {
                return openRawResourceFd;
            }
            throw new RawResourceDataSourceException("Resource is compressed: " + normalizeScheme, null, 2000);
        } catch (Resources.NotFoundException e12) {
            throw new RawResourceDataSourceException(null, e12, 2005);
        }
    }

    private static int i(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, 1004);
        }
    }

    @Override // androidx.media3.datasource.a
    public long a(h hVar) {
        this.f10786f = hVar;
        f(hVar);
        AssetFileDescriptor h11 = h(this.f10785e, hVar);
        this.f10787g = h11;
        long length = h11.getLength();
        FileInputStream fileInputStream = new FileInputStream(this.f10787g.getFileDescriptor());
        this.f10788h = fileInputStream;
        if (length != -1) {
            try {
                if (hVar.f77640g > length) {
                    throw new RawResourceDataSourceException(null, null, 2008);
                }
            } catch (RawResourceDataSourceException e11) {
                throw e11;
            } catch (IOException e12) {
                throw new RawResourceDataSourceException(null, e12, 2000);
            }
        }
        long startOffset = this.f10787g.getStartOffset();
        long skip = fileInputStream.skip(hVar.f77640g + startOffset) - startOffset;
        if (skip != hVar.f77640g) {
            throw new RawResourceDataSourceException(null, null, 2008);
        }
        if (length == -1) {
            FileChannel channel = fileInputStream.getChannel();
            if (channel.size() == 0) {
                this.f10789i = -1L;
            } else {
                long size = channel.size() - channel.position();
                this.f10789i = size;
                if (size < 0) {
                    throw new RawResourceDataSourceException(null, null, 2008);
                }
            }
        } else {
            long j11 = length - skip;
            this.f10789i = j11;
            if (j11 < 0) {
                throw new DataSourceException(2008);
            }
        }
        long j12 = hVar.f77641h;
        if (j12 != -1) {
            long j13 = this.f10789i;
            if (j13 != -1) {
                j12 = Math.min(j13, j12);
            }
            this.f10789i = j12;
        }
        this.f10790j = true;
        g(hVar);
        long j14 = hVar.f77641h;
        return j14 != -1 ? j14 : this.f10789i;
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        this.f10786f = null;
        try {
            try {
                InputStream inputStream = this.f10788h;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f10788h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f10787g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e11) {
                        throw new RawResourceDataSourceException(null, e11, 2000);
                    }
                } finally {
                    this.f10787g = null;
                    if (this.f10790j) {
                        this.f10790j = false;
                        e();
                    }
                }
            } catch (IOException e12) {
                throw new RawResourceDataSourceException(null, e12, 2000);
            }
        } catch (Throwable th2) {
            this.f10788h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f10787g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f10787g = null;
                    if (this.f10790j) {
                        this.f10790j = false;
                        e();
                    }
                    throw th2;
                } catch (IOException e13) {
                    throw new RawResourceDataSourceException(null, e13, 2000);
                }
            } finally {
                this.f10787g = null;
                if (this.f10790j) {
                    this.f10790j = false;
                    e();
                }
            }
        }
    }

    @Override // androidx.media3.datasource.a
    public Uri getUri() {
        h hVar = this.f10786f;
        if (hVar != null) {
            return hVar.f77634a;
        }
        return null;
    }

    @Override // androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f10789i;
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
        int read = ((InputStream) a1.i(this.f10788h)).read(bArr, i11, i12);
        if (read == -1) {
            if (this.f10789i == -1) {
                return -1;
            }
            throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j12 = this.f10789i;
        if (j12 != -1) {
            this.f10789i = j12 - read;
        }
        d(read);
        return read;
    }
}
