package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.mbsignalcommon.mapping.b;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class h implements b, Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    protected Pattern f36621a;

    /* renamed from: b, reason: collision with root package name */
    protected String f36622b;

    /* renamed from: d, reason: collision with root package name */
    protected Context f36624d;

    /* renamed from: e, reason: collision with root package name */
    protected WindVaneWebView f36625e;

    /* renamed from: c, reason: collision with root package name */
    protected final int f36623c = 1;

    /* renamed from: f, reason: collision with root package name */
    protected Handler f36626f = new Handler(Looper.getMainLooper(), this);

    public h(Context context) {
        this.f36624d = context;
    }

    protected void a(int i11, a aVar) {
        Message obtain = Message.obtain();
        obtain.what = i11;
        obtain.obj = aVar;
        this.f36626f.sendMessage(obtain);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.b
    public void a(WindVaneWebView windVaneWebView) {
        this.f36625e = windVaneWebView;
    }

    protected void a(a aVar) {
        WindVaneWebView windVaneWebView = aVar.f36595b;
        Object jsObject = windVaneWebView == null ? null : windVaneWebView.getJsObject(aVar.f36597d);
        if (jsObject == null) {
            return;
        }
        try {
            b.C0515b a11 = com.mbridge.msdk.mbsignalcommon.mapping.b.a(this.f36624d.getClassLoader(), jsObject.getClass().getName()).a(aVar.f36598e, Object.class, String.class);
            a11.a();
            if (jsObject instanceof g) {
                aVar.f36594a = a11;
                aVar.f36596c = jsObject;
                a(1, aVar);
            }
        } catch (com.mbridge.msdk.mbsignalcommon.mapping.a e11) {
            e11.printStackTrace();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.b
    public void a(String str) {
        a c11;
        if (TextUtils.isEmpty(str) || (c11 = c(str)) == null) {
            return;
        }
        a(c11);
    }

    public void a(Pattern pattern) {
        this.f36621a = pattern;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.b
    public boolean b(String str) {
        if (!i.f(str)) {
            return false;
        }
        a(i.c(str));
        d(str);
        return true;
    }

    public a c(String str) {
        if (str == null) {
            return null;
        }
        a a11 = com.mbridge.msdk.mbsignalcommon.mraid.c.a(this.f36625e, str);
        if (a11 != null) {
            a11.f36595b = this.f36625e;
            return a11;
        }
        Matcher matcher = this.f36621a.matcher(str);
        if (matcher.matches()) {
            a aVar = new a();
            int groupCount = matcher.groupCount();
            if (groupCount >= 5) {
                aVar.f36599f = matcher.group(5);
            }
            if (groupCount >= 3) {
                aVar.f36597d = matcher.group(1);
                aVar.f36600g = matcher.group(2);
                String group = matcher.group(3);
                aVar.f36598e = group;
                HashMap<String, String> hashMap = com.mbridge.msdk.mbsignalcommon.base.e.f36496k;
                if (hashMap != null && hashMap.containsKey(group)) {
                    aVar.f36598e = com.mbridge.msdk.mbsignalcommon.base.e.f36496k.get(aVar.f36598e);
                }
                aVar.f36595b = this.f36625e;
                return aVar;
            }
        }
        return null;
    }

    public void d(String str) {
        this.f36622b = str;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar = (a) message.obj;
        if (aVar == null) {
            return false;
        }
        try {
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (message.what != 1) {
            return false;
        }
        Object obj = aVar.f36596c;
        b.C0515b c0515b = aVar.f36594a;
        if (c0515b != null && obj != null) {
            c0515b.a(obj, aVar, TextUtils.isEmpty(aVar.f36599f) ? "{}" : aVar.f36599f);
        }
        return true;
    }
}
