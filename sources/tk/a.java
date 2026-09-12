package tk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.UserManager;
import android.text.TextUtils;
import com.transsion.athena.attribution.AttrConstant;
import sk.b;
import sk.d;
import sk.e;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f76397b;

    /* renamed from: c, reason: collision with root package name */
    private static Context f76398c;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f76399a;

    private a(Context context) {
        f76398c = context.getApplicationContext();
        c(context);
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (f76397b == null) {
                    f76397b = new a(context);
                }
                aVar = f76397b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    private SharedPreferences c(Context context) {
        boolean isUserUnlocked;
        Context createDeviceProtectedStorageContext;
        if (Build.VERSION.SDK_INT < 24) {
            SharedPreferences sharedPreferences = this.f76399a;
            if (sharedPreferences != null) {
                return sharedPreferences;
            }
            if (context == null) {
                return null;
            }
            try {
                this.f76399a = context.getSharedPreferences(AttrConstant.SP_NAME, 0);
            } catch (Exception unused) {
            }
            return this.f76399a;
        }
        isUserUnlocked = ((UserManager) context.getSystemService("user")).isUserUnlocked();
        try {
            if (isUserUnlocked) {
                SharedPreferences sharedPreferences2 = context.getSharedPreferences(AttrConstant.SP_NAME, 0);
                this.f76399a = sharedPreferences2;
                return sharedPreferences2;
            }
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            SharedPreferences sharedPreferences3 = createDeviceProtectedStorageContext.getSharedPreferences(AttrConstant.SP_NAME, 0);
            this.f76399a = sharedPreferences3;
            return sharedPreferences3;
        } catch (Exception unused2) {
            return null;
        }
    }

    public String b(String str) {
        if (f76398c == null || !e.b().a(f76398c)) {
            return "";
        }
        if (this.f76399a == null) {
            this.f76399a = c(f76398c);
        }
        if (this.f76399a == null) {
            return "";
        }
        try {
            d dVar = new d(f76398c);
            String string = this.f76399a.getString(str, "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            String[] split = string.split("_");
            int length = split.length;
            byte[] d11 = dVar.d(dVar.a(split[1]));
            int length2 = d11.length;
            byte[] bArr = new byte[32];
            byte[] bArr2 = new byte[16];
            System.arraycopy(d11, 0, bArr, 0, 32);
            System.arraycopy(d11, 32, bArr2, 0, 16);
            sk.a aVar = new sk.a(bArr, bArr2);
            return new String(aVar.d(aVar.a(split[0])));
        } catch (Exception unused) {
            return "";
        }
    }

    public void d(String str, String str2) {
        if (f76398c == null) {
            throw new Exception("context is null");
        }
        if (!e.b().a(f76398c)) {
            throw new Exception("key not created");
        }
        if (this.f76399a == null) {
            this.f76399a = c(f76398c);
        }
        if (this.f76399a == null) {
            throw new Exception("sp is null");
        }
        try {
            b bVar = new b();
            d dVar = new d(f76398c);
            String c11 = bVar.c(bVar.e(str2));
            String c12 = dVar.c(dVar.e(bVar.i()));
            this.f76399a.edit().putString(str, c11 + "_" + c12).apply();
        } catch (Exception unused) {
        }
    }
}
