package gm;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.blankj.utilcode.util.Utils;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.mvel2.ast.ASTNode;

/* loaded from: classes5.dex */
public abstract class g extends BridgeWebView.BaseJavascriptInterface {

    /* renamed from: a, reason: collision with root package name */
    private final BridgeWebView f64004a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(BridgeWebView customWebView) {
        super(customWebView.getCallbacks());
        Intrinsics.h(customWebView, "customWebView");
        this.f64004a = customWebView;
    }

    private final String a() {
        ArrayList arrayList = new ArrayList();
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://"));
        ResolveInfo resolveActivity = a11.getPackageManager().resolveActivity(intent, 65536);
        String str = null;
        String str2 = (resolveActivity != null ? resolveActivity.activityInfo : null) != null ? resolveActivity.activityInfo.packageName : null;
        if (str2 != null && !Intrinsics.c(str2, "android")) {
            return str2;
        }
        List<ResolveInfo> queryIntentActivities = a11.getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.g(queryIntentActivities, "queryIntentActivities(...)");
        Iterator<ResolveInfo> it = queryIntentActivities.iterator();
        String str3 = null;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if ((activityInfo.flags & 1) != 0) {
                str = activityInfo.packageName;
            } else {
                str3 = activityInfo.packageName;
                arrayList.add(str3);
            }
        }
        if (arrayList.contains("com.android.chrome")) {
            return "com.android.chrome";
        }
        if (str != null) {
            str2 = str;
        }
        return str3 != null ? str3 : str2;
    }

    private final boolean b() {
        return StringsKt.H("huawei", Build.MANUFACTURER, true);
    }

    @JavascriptInterface
    public void close() {
    }

    @JavascriptInterface
    public void openBrowser(String url) {
        Intrinsics.h(url, "url");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("openBrowser() --> url = ");
        sb2.append(url);
        try {
            Intent parseUri = StringsKt.W(url, "intent", false, 2, null) ? Intent.parseUri(url, 1) : new Intent("android.intent.action.VIEW", Uri.parse(url));
            if (parseUri != null) {
                if (b()) {
                    parseUri.setPackage(a());
                }
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent(null);
                parseUri.setFlags(ASTNode.DEOP);
            }
            Utils.a().startActivity(parseUri);
        } catch (Exception e11) {
            Log.e("gs_log", "openBrowser() --> url = " + url + " --> e = " + e11);
        }
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeWebView.BaseJavascriptInterface
    public String send(String str) {
        return "send";
    }
}
