package im;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.transsion.lib_web.LoadUrlData;
import gm.i;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b implements com.transsion.lib_web.zip.loader.c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f65382d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final Context f65383b;

    /* renamed from: c, reason: collision with root package name */
    private final LoadUrlData f65384c;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(Context context, LoadUrlData loadUrlData) {
        Intrinsics.h(context, "context");
        Intrinsics.h(loadUrlData, "loadUrlData");
        this.f65383b = context;
        this.f65384c = loadUrlData;
    }

    @Override // com.transsion.lib_web.zip.loader.c
    public WebResourceResponse a(WebResourceRequest webResourceRequest) {
        Uri url;
        String uri;
        if (webResourceRequest != null) {
            try {
                url = webResourceRequest.getUrl();
            } catch (Throwable unused) {
            }
            if (url != null) {
                uri = url.toString();
                if (uri != null && !Intrinsics.c(uri, "yy://__QUEUE_MESSAGE__") && Intrinsics.c(uri, this.f65384c.getOriginUrl())) {
                    i.f64006a.a("DR_WebviewRenderHomePageFileLoader", "<interceptRequest> url:" + uri + " is home page");
                    com.transsion.lib_web.download_render.utils.a aVar = com.transsion.lib_web.download_render.utils.a.f46239a;
                    aVar.n();
                    aVar.a(uri, this.f65384c.getSource());
                }
                return null;
            }
        }
        uri = null;
        if (uri != null) {
            i.f64006a.a("DR_WebviewRenderHomePageFileLoader", "<interceptRequest> url:" + uri + " is home page");
            com.transsion.lib_web.download_render.utils.a aVar2 = com.transsion.lib_web.download_render.utils.a.f46239a;
            aVar2.n();
            aVar2.a(uri, this.f65384c.getSource());
        }
        return null;
    }
}
