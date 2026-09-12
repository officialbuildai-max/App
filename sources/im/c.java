package im;

import android.content.Context;
import com.transsion.lib_web.LoadUrlData;
import com.transsion.lib_web.zip.loader.c;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c implements com.transsion.lib_web.zip.loader.c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f65385d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final Context f65386b;

    /* renamed from: c, reason: collision with root package name */
    private final LoadUrlData f65387c;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(Context context, LoadUrlData loadUrlData) {
        Intrinsics.h(context, "context");
        Intrinsics.h(loadUrlData, "loadUrlData");
        this.f65386b = context;
        this.f65387c = loadUrlData;
        com.transsion.lib_web.download_render.c.f46221a.v(loadUrlData.getOriginUrl());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[Catch: all -> 0x01d6, TRY_ENTER, TryCatch #0 {all -> 0x01d6, blocks: (B:50:0x0005, B:52:0x000b, B:5:0x0013, B:8:0x001d, B:11:0x0032, B:14:0x004c, B:16:0x0052, B:18:0x006c, B:21:0x0079, B:23:0x009b, B:25:0x00a3, B:27:0x00ab, B:29:0x00ce, B:31:0x00d6, B:33:0x0109, B:35:0x010f, B:37:0x0132, B:39:0x013d, B:41:0x016c, B:43:0x017d, B:45:0x0188, B:47:0x0183), top: B:49:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[Catch: all -> 0x01d6, TryCatch #0 {all -> 0x01d6, blocks: (B:50:0x0005, B:52:0x000b, B:5:0x0013, B:8:0x001d, B:11:0x0032, B:14:0x004c, B:16:0x0052, B:18:0x006c, B:21:0x0079, B:23:0x009b, B:25:0x00a3, B:27:0x00ab, B:29:0x00ce, B:31:0x00d6, B:33:0x0109, B:35:0x010f, B:37:0x0132, B:39:0x013d, B:41:0x016c, B:43:0x017d, B:45:0x0188, B:47:0x0183), top: B:49:0x0005 }] */
    @Override // com.transsion.lib_web.zip.loader.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.webkit.WebResourceResponse a(android.webkit.WebResourceRequest r17) {
        /*
            Method dump skipped, instructions count: 482
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: im.c.a(android.webkit.WebResourceRequest):android.webkit.WebResourceResponse");
    }

    public Map b(Map map) {
        return c.b.a(this, map);
    }
}
