package k4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.athena.attribution.AttrConstant;
import com.transsion.athena.taaneh.aethna;
import com.transsion.athena.taaneh.athena;
import nq.c;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static b f66760c;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f66761a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f66762b;

    private b(Context context) {
        this.f66762b = context.getApplicationContext();
    }

    public static synchronized b b(Context context) {
        b bVar;
        synchronized (b.class) {
            try {
                if (f66760c == null) {
                    f66760c = new b(context);
                }
                bVar = f66760c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    private SharedPreferences d(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(athena.d(context) + "_" + AttrConstant.SP_NAME, 0);
                this.f66761a = sharedPreferences;
                return sharedPreferences;
            } catch (Exception e11) {
                aethna.b(Log.getStackTraceString(e11));
                return null;
            }
        }
        SharedPreferences sharedPreferences2 = this.f66761a;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        if (context == null) {
            return null;
        }
        try {
            this.f66761a = context.getSharedPreferences(athena.d(context) + "_" + AttrConstant.SP_NAME, 0);
        } catch (Exception e12) {
            aethna.b(Log.getStackTraceString(e12));
        }
        return this.f66761a;
    }

    public String a(String str) {
        Context context = this.f66762b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f66761a == null) {
            this.f66761a = d(context);
        }
        if (this.f66761a == null) {
            throw new Exception("sp is null");
        }
        if (!c.b().a(this.f66762b)) {
            throw new Exception("keystore decrypt error");
        }
        String string = this.f66761a.getString(str, "");
        if (TextUtils.isEmpty(string) || string.contains("_")) {
            return "";
        }
        nq.b bVar = new nq.b();
        String str2 = new String(bVar.d(bVar.a(string)));
        if (TextUtils.isEmpty(str2)) {
            throw new Exception("rsaCrypter decrypt error");
        }
        return str2;
    }

    public void c(String str, String str2) {
        Context context = this.f66762b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f66761a == null) {
            this.f66761a = d(context);
        }
        if (this.f66761a == null) {
            throw new Exception("sp is null");
        }
        try {
            if (!c.b().a(this.f66762b)) {
                throw new Exception("keystore encrypt error");
            }
            nq.b bVar = new nq.b();
            String c11 = bVar.c(bVar.e(str2));
            if (TextUtils.isEmpty(c11)) {
                throw new Exception("rsaCrypter encrypt error");
            }
            SharedPreferences.Editor edit = this.f66761a.edit();
            edit.putString(str, c11);
            edit.apply();
        } catch (Exception e11) {
            aethna.b(Log.getStackTraceString(e11));
            throw e11;
        }
    }
}
