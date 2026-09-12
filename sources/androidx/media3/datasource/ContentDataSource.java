package androidx.media3.datasource;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.media3.common.util.a1;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import w1.h;

/* loaded from: classes2.dex */
public final class ContentDataSource extends w1.a {

    /* renamed from: e, reason: collision with root package name */
    private final ContentResolver f10772e;

    /* renamed from: f, reason: collision with root package name */
    private Uri f10773f;

    /* renamed from: g, reason: collision with root package name */
    private AssetFileDescriptor f10774g;

    /* renamed from: h, reason: collision with root package name */
    private FileInputStream f10775h;

    /* renamed from: i, reason: collision with root package name */
    private long f10776i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f10777j;

    /* loaded from: classes2.dex */
    public static class ContentDataSourceException extends DataSourceException {
        @Deprecated
        public ContentDataSourceException(IOException iOException) {
            this(iOException, 2000);
        }

        public ContentDataSourceException(@Nullable IOException iOException, int i11) {
            super(iOException, i11);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f10772e = context.getContentResolver();
    }

    @Override // androidx.media3.datasource.a
    public long a(h hVar) {
        AssetFileDescriptor openAssetFileDescriptor;
        try {
            Uri normalizeScheme = hVar.f77634a.normalizeScheme();
            this.f10773f = normalizeScheme;
            f(hVar);
            if ("content".equals(normalizeScheme.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                openAssetFileDescriptor = this.f10772e.openTypedAssetFileDescriptor(normalizeScheme, "*/*", bundle);
            } else {
                openAssetFileDescriptor = this.f10772e.openAssetFileDescriptor(normalizeScheme, CampaignEx.JSON_KEY_AD_R);
            }
            this.f10774g = openAssetFileDescriptor;
            if (openAssetFileDescriptor == null) {
                throw new ContentDataSourceException(new IOException("Could not open file descriptor for: " + normalizeScheme), 2000);
            }
            long length = openAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
            this.f10775h = fileInputStream;
            if (length != -1 && hVar.f77640g > length) {
                throw new ContentDataSourceException(null, 2008);
            }
            long startOffset = openAssetFileDescriptor.getStartOffset();
            long skip = fileInputStream.skip(hVar.f77640g + startOffset) - startOffset;
            if (skip != hVar.f77640g) {
                throw new ContentDataSourceException(null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.f10776i = -1L;
                } else {
                    long position = size - channel.position();
                    this.f10776i = position;
                    if (position < 0) {
                        throw new ContentDataSourceException(null, 2008);
                    }
                }
            } else {
                long j11 = length - skip;
                this.f10776i = j11;
                if (j11 < 0) {
                    throw new ContentDataSourceException(null, 2008);
                }
            }
            long j12 = hVar.f77641h;
            if (j12 != -1) {
                long j13 = this.f10776i;
                if (j13 != -1) {
                    j12 = Math.min(j13, j12);
                }
                this.f10776i = j12;
            }
            this.f10777j = true;
            g(hVar);
            long j14 = hVar.f77641h;
            return j14 != -1 ? j14 : this.f10776i;
        } catch (ContentDataSourceException e11) {
            throw e11;
        } catch (IOException e12) {
            throw new ContentDataSourceException(e12, e12 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        this.f10773f = null;
        try {
            try {
                FileInputStream fileInputStream = this.f10775h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f10775h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f10774g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e11) {
                        throw new ContentDataSourceException(e11, 2000);
                    }
                } finally {
                    this.f10774g = null;
                    if (this.f10777j) {
                        this.f10777j = false;
                        e();
                    }
                }
            } catch (IOException e12) {
                throw new ContentDataSourceException(e12, 2000);
            }
        } catch (Throwable th2) {
            this.f10775h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f10774g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f10774g = null;
                    if (this.f10777j) {
                        this.f10777j = false;
                        e();
                    }
                    throw th2;
                } catch (IOException e13) {
                    throw new ContentDataSourceException(e13, 2000);
                }
            } finally {
                this.f10774g = null;
                if (this.f10777j) {
                    this.f10777j = false;
                    e();
                }
            }
        }
    }

    @Override // androidx.media3.datasource.a
    public Uri getUri() {
        return this.f10773f;
    }

    @Override // androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f10776i;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, i12);
            } catch (IOException e11) {
                throw new ContentDataSourceException(e11, 2000);
            }
        }
        int read = ((FileInputStream) a1.i(this.f10775h)).read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        long j12 = this.f10776i;
        if (j12 != -1) {
            this.f10776i = j12 - read;
        }
        d(read);
        return read;
    }
}
