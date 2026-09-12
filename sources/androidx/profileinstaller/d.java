package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final AssetManager f14108a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f14109b;

    /* renamed from: c, reason: collision with root package name */
    private final h.c f14110c;

    /* renamed from: e, reason: collision with root package name */
    private final File f14112e;

    /* renamed from: f, reason: collision with root package name */
    private final String f14113f;

    /* renamed from: g, reason: collision with root package name */
    private final String f14114g;

    /* renamed from: h, reason: collision with root package name */
    private final String f14115h;

    /* renamed from: j, reason: collision with root package name */
    private e[] f14117j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f14118k;

    /* renamed from: i, reason: collision with root package name */
    private boolean f14116i = false;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f14111d = d();

    public d(AssetManager assetManager, Executor executor, h.c cVar, String str, String str2, String str3, File file) {
        this.f14108a = assetManager;
        this.f14109b = executor;
        this.f14110c = cVar;
        this.f14113f = str;
        this.f14114g = str2;
        this.f14115h = str3;
        this.f14112e = file;
    }

    private d b(e[] eVarArr, byte[] bArr) {
        InputStream h11;
        try {
            h11 = h(this.f14108a, this.f14115h);
        } catch (FileNotFoundException e11) {
            this.f14110c.a(9, e11);
        } catch (IOException e12) {
            this.f14110c.a(7, e12);
        } catch (IllegalStateException e13) {
            this.f14117j = null;
            this.f14110c.a(8, e13);
        }
        if (h11 == null) {
            if (h11 != null) {
                h11.close();
            }
            return null;
        }
        try {
            this.f14117j = l.r(h11, l.p(h11, l.f14138b), bArr, eVarArr);
            h11.close();
            return this;
        } catch (Throwable th2) {
            try {
                h11.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private void c() {
        if (!this.f14116i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] d() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 24) {
            return null;
        }
        if (i11 >= 31) {
            return n.f14150a;
        }
        switch (i11) {
            case 24:
            case 25:
                return n.f14154e;
            case 26:
                return n.f14153d;
            case 27:
                return n.f14152c;
            case 28:
            case NOTIFICATION_REDIRECT_VALUE:
            case 30:
                return n.f14151b;
            default:
                return null;
        }
    }

    private InputStream f(AssetManager assetManager) {
        try {
            return h(assetManager, this.f14114g);
        } catch (FileNotFoundException e11) {
            this.f14110c.a(6, e11);
            return null;
        } catch (IOException e12) {
            this.f14110c.a(7, e12);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i11, Object obj) {
        this.f14110c.a(i11, obj);
    }

    private InputStream h(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e11) {
            String message = e11.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f14110c.b(5, null);
            }
            return null;
        }
    }

    private e[] j(InputStream inputStream) {
        try {
            try {
                try {
                    try {
                        e[] x10 = l.x(inputStream, l.p(inputStream, l.f14137a), this.f14113f);
                        try {
                            inputStream.close();
                            return x10;
                        } catch (IOException e11) {
                            this.f14110c.a(7, e11);
                            return x10;
                        }
                    } catch (IOException e12) {
                        this.f14110c.a(7, e12);
                        return null;
                    }
                } catch (IllegalStateException e13) {
                    this.f14110c.a(8, e13);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e14) {
                this.f14110c.a(7, e14);
                inputStream.close();
                return null;
            }
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e15) {
                this.f14110c.a(7, e15);
            }
            throw th2;
        }
    }

    private static boolean k() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 24) {
            return false;
        }
        return i11 >= 31 || i11 == 24 || i11 == 25;
    }

    private void l(final int i11, final Object obj) {
        this.f14109b.execute(new Runnable() { // from class: androidx.profileinstaller.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.g(i11, obj);
            }
        });
    }

    public boolean e() {
        if (this.f14111d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f14112e.exists()) {
            try {
                if (!this.f14112e.createNewFile()) {
                    l(4, null);
                    return false;
                }
            } catch (IOException unused) {
                l(4, null);
                return false;
            }
        } else if (!this.f14112e.canWrite()) {
            l(4, null);
            return false;
        }
        this.f14116i = true;
        return true;
    }

    public d i() {
        d b11;
        c();
        if (this.f14111d == null) {
            return this;
        }
        InputStream f11 = f(this.f14108a);
        if (f11 != null) {
            this.f14117j = j(f11);
        }
        e[] eVarArr = this.f14117j;
        return (eVarArr == null || !k() || (b11 = b(eVarArr, this.f14111d)) == null) ? this : b11;
    }

    public d m() {
        ByteArrayOutputStream byteArrayOutputStream;
        e[] eVarArr = this.f14117j;
        byte[] bArr = this.f14111d;
        if (eVarArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    l.F(byteArrayOutputStream, bArr);
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (IOException e11) {
                this.f14110c.a(7, e11);
            } catch (IllegalStateException e12) {
                this.f14110c.a(8, e12);
            }
            if (!l.C(byteArrayOutputStream, bArr, eVarArr)) {
                this.f14110c.a(5, null);
                this.f14117j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f14118k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f14117j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean n() {
        byte[] bArr = this.f14118k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f14112e);
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        try {
                            FileLock tryLock = channel.tryLock();
                            try {
                                f.l(byteArrayInputStream, fileOutputStream, tryLock);
                                l(1, null);
                                if (tryLock != null) {
                                    tryLock.close();
                                }
                                channel.close();
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                                return true;
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th5) {
                        th4.addSuppressed(th5);
                    }
                    throw th4;
                }
            } catch (FileNotFoundException e11) {
                l(6, e11);
                return false;
            } catch (IOException e12) {
                l(7, e12);
                return false;
            }
        } finally {
            this.f14118k = null;
            this.f14117j = null;
        }
    }
}
