package com.bytedance.sdk.openadsdk.zR;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class sP {
    private SharedPreferences Sj;
    private final String TKC;
    private final Context sP;

    public sP(Context context, String str) {
        this.sP = context;
        this.TKC = str;
    }

    private SharedPreferences sP() {
        Context context;
        SharedPreferences sharedPreferences = this.Sj;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        if (TextUtils.isEmpty(this.TKC) || (context = this.sP) == null) {
            return null;
        }
        try {
            this.Sj = context.getSharedPreferences(this.TKC, 0);
        } catch (Throwable th2) {
            Log.e("SPUnit", th2.getMessage());
        }
        return this.Sj;
    }

    public int Sj(String str, int i11) {
        try {
            SharedPreferences sP = sP();
            if (sP != null && sP.contains(str)) {
                return sP.getInt(str, i11);
            }
            return i11;
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.TKC);
            sb2.append(th2.getMessage());
            return i11;
        }
    }

    public String Sj(String str, String str2) {
        try {
            SharedPreferences sP = sP();
            if (sP != null && sP.contains(str)) {
                return sP.getString(str, str2);
            }
            return str2;
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.TKC);
            sb2.append(th2.getMessage());
            return str2;
        }
    }

    public void Sj() {
        SharedPreferences sP = sP();
        if (sP != null) {
            SharedPreferences.Editor edit = sP.edit();
            edit.clear();
            edit.commit();
        }
    }

    public void Sj(String str, long j11) {
        try {
            SharedPreferences sP = sP();
            if (sP != null) {
                SharedPreferences.Editor edit = sP.edit();
                edit.putLong(str, j11);
                edit.apply();
            }
        } catch (Throwable th2) {
            Log.e("SPUnit", th2.getMessage());
        }
    }

    public void Sj(JSONObject jSONObject) {
        try {
            SharedPreferences sP = sP();
            if (sP != null) {
                SharedPreferences.Editor edit = sP.edit();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        if (!TextUtils.isEmpty(next)) {
                            Object obj = jSONObject.get(next);
                            if (obj instanceof Integer) {
                                edit.putInt(next, ((Integer) obj).intValue());
                            } else if (obj instanceof Long) {
                                edit.putLong(next, ((Long) obj).longValue());
                            } else if (obj instanceof String) {
                                edit.putString(next, (String) obj);
                            } else if (obj instanceof Boolean) {
                                edit.putBoolean(next, ((Boolean) obj).booleanValue());
                            } else if (obj instanceof Float) {
                                edit.putFloat(next, ((Float) obj).floatValue());
                            } else if (obj instanceof Double) {
                                Double d11 = (Double) obj;
                                d11.doubleValue();
                                edit.putFloat(next, d11.floatValue());
                            }
                        }
                    } catch (Throwable th2) {
                        Log.e("SPUnit", th2.getMessage());
                    }
                }
                edit.apply();
            }
        } catch (Throwable th3) {
            Log.e("SPUnit", th3.getMessage());
        }
    }

    public boolean Sj(String str, boolean z10) {
        try {
            SharedPreferences sP = sP();
            if (sP != null && sP.contains(str)) {
                return sP.getBoolean(str, z10);
            }
            return z10;
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.TKC);
            sb2.append(th2.getMessage());
            return z10;
        }
    }

    public long sP(String str, long j11) {
        try {
            SharedPreferences sP = sP();
            if (sP != null && sP.contains(str)) {
                return sP.getLong(str, j11);
            }
            return j11;
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.TKC);
            sb2.append(th2.getMessage());
            return j11;
        }
    }
}
