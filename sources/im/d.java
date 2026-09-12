package im;

import android.content.Context;
import com.transsion.lib_web.LoadUrlData;
import com.transsion.lib_web.zip.loader.c;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d implements com.transsion.lib_web.zip.loader.c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f65388d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final Context f65389b;

    /* renamed from: c, reason: collision with root package name */
    private final LoadUrlData f65390c;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(Context context, LoadUrlData loadUrlData) {
        Intrinsics.h(context, "context");
        Intrinsics.h(loadUrlData, "loadUrlData");
        this.f65389b = context;
        this.f65390c = loadUrlData;
        com.transsion.lib_web.download_render.c.f46221a.v(loadUrlData.getOriginUrl());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[Catch: all -> 0x01e6, TRY_ENTER, TryCatch #0 {all -> 0x01e6, blocks: (B:53:0x0005, B:55:0x000b, B:5:0x0013, B:8:0x001d, B:11:0x0032, B:14:0x004c, B:16:0x006e, B:18:0x0091, B:21:0x009e, B:24:0x00ab, B:26:0x00b7, B:28:0x00bf, B:30:0x00c7, B:32:0x00ea, B:34:0x00f2, B:36:0x0125, B:38:0x012b, B:40:0x014e, B:42:0x0159, B:44:0x0188, B:46:0x0199, B:48:0x01a4, B:50:0x019f), top: B:52:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[Catch: all -> 0x01e6, TryCatch #0 {all -> 0x01e6, blocks: (B:53:0x0005, B:55:0x000b, B:5:0x0013, B:8:0x001d, B:11:0x0032, B:14:0x004c, B:16:0x006e, B:18:0x0091, B:21:0x009e, B:24:0x00ab, B:26:0x00b7, B:28:0x00bf, B:30:0x00c7, B:32:0x00ea, B:34:0x00f2, B:36:0x0125, B:38:0x012b, B:40:0x014e, B:42:0x0159, B:44:0x0188, B:46:0x0199, B:48:0x01a4, B:50:0x019f), top: B:52:0x0005 }] */
    @Override // com.transsion.lib_web.zip.loader.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.webkit.WebResourceResponse a(android.webkit.WebResourceRequest r17) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: im.d.a(android.webkit.WebResourceRequest):android.webkit.WebResourceResponse");
    }

    public Map b(Map map) {
        return c.b.a(this, map);
    }
}
