package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes3.dex */
public final class ContentDataSource extends f {

    /* renamed from: e, reason: collision with root package name */
    private final ContentResolver f27287e;

    /* renamed from: f, reason: collision with root package name */
    private Uri f27288f;

    /* renamed from: g, reason: collision with root package name */
    private AssetFileDescriptor f27289g;

    /* renamed from: h, reason: collision with root package name */
    private FileInputStream f27290h;

    /* renamed from: i, reason: collision with root package name */
    private long f27291i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f27292j;

    /* loaded from: classes3.dex */
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
        this.f27287e = context.getContentResolver();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) {
        AssetFileDescriptor openAssetFileDescriptor;
        try {
            Uri uri = nVar.f27491a;
            this.f27288f = uri;
            j(nVar);
            if ("content".equals(nVar.f27491a.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                openAssetFileDescriptor = this.f27287e.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                openAssetFileDescriptor = this.f27287e.openAssetFileDescriptor(uri, CampaignEx.JSON_KEY_AD_R);
            }
            this.f27289g = openAssetFileDescriptor;
            if (openAssetFileDescriptor == null) {
                throw new ContentDataSourceException(new IOException("Could not open file descriptor for: " + uri), 2000);
            }
            long length = openAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
            this.f27290h = fileInputStream;
            if (length != -1 && nVar.f27497g > length) {
                throw new ContentDataSourceException(null, 2008);
            }
            long startOffset = openAssetFileDescriptor.getStartOffset();
            long skip = fileInputStream.skip(nVar.f27497g + startOffset) - startOffset;
            if (skip != nVar.f27497g) {
                throw new ContentDataSourceException(null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.f27291i = -1L;
                } else {
                    long position = size - channel.position();
                    this.f27291i = position;
                    if (position < 0) {
                        throw new ContentDataSourceException(null, 2008);
                    }
                }
            } else {
                long j11 = length - skip;
                this.f27291i = j11;
                if (j11 < 0) {
                    throw new ContentDataSourceException(null, 2008);
                }
            }
            long j12 = nVar.f27498h;
            if (j12 != -1) {
                long j13 = this.f27291i;
                if (j13 != -1) {
                    j12 = Math.min(j13, j12);
                }
                this.f27291i = j12;
            }
            this.f27292j = true;
            k(nVar);
            long j14 = nVar.f27498h;
            return j14 != -1 ? j14 : this.f27291i;
        } catch (ContentDataSourceException e11) {
            throw e11;
        } catch (IOException e12) {
            throw new ContentDataSourceException(e12, e12 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        this.f27288f = null;
        try {
            try {
                FileInputStream fileInputStream = this.f27290h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f27290h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f27289g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e11) {
                        throw new ContentDataSourceException(e11, 2000);
                    }
                } finally {
                    this.f27289g = null;
                    if (this.f27292j) {
                        this.f27292j = false;
                        i();
                    }
                }
            } catch (IOException e12) {
                throw new ContentDataSourceException(e12, 2000);
            }
        } catch (Throwable th2) {
            this.f27290h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f27289g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f27289g = null;
                    if (this.f27292j) {
                        this.f27292j = false;
                        i();
                    }
                    throw th2;
                } catch (IOException e13) {
                    throw new ContentDataSourceException(e13, 2000);
                }
            } finally {
                this.f27289g = null;
                if (this.f27292j) {
                    this.f27292j = false;
                    i();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Uri getUri() {
        return this.f27288f;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f27291i;
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
        int read = ((FileInputStream) p0.j(this.f27290h)).read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        long j12 = this.f27291i;
        if (j12 != -1) {
            this.f27291i = j12 - read;
        }
        h(read);
        return read;
    }
}
