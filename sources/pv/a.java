package pv;

import com.transsion.ugcvideodetail.api.bean.UGCVideoPlayInfo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoPlayStream;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f72623a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static String f72624b = "";

    private a() {
    }

    private final boolean b(UGCVideoPlayStream uGCVideoPlayStream, String str) {
        Integer v11 = StringsKt.v(str);
        int intValue = v11 != null ? v11.intValue() : 0;
        Integer v12 = StringsKt.v(uGCVideoPlayStream.getResolutions());
        int intValue2 = v12 != null ? v12.intValue() : 0;
        return intValue2 > 0 && intValue > 0 && intValue2 > intValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [com.transsion.ugcvideodetail.api.bean.UGCVideoPlayStream] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.transsion.ugcvideodetail.api.bean.UGCVideoPlayStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object] */
    private final UGCVideoPlayStream c(List list) {
        UGCVideoPlayStream uGCVideoPlayStream;
        Object obj;
        if (list.isEmpty()) {
            return null;
        }
        String d11 = d();
        a.C0856a.f(lg.a.f68962a, "UGCResolutionHelper", "getMp4DefaultPlayBean, savedResolution： " + f72624b, false, 4, null);
        List<UGCVideoPlayStream> list2 = list;
        UGCVideoPlayStream uGCVideoPlayStream2 = 0;
        for (UGCVideoPlayStream uGCVideoPlayStream3 : list2) {
            if (!uGCVideoPlayStream3.isOnline()) {
                uGCVideoPlayStream2 = uGCVideoPlayStream3;
            }
        }
        if (uGCVideoPlayStream2 != 0) {
            return uGCVideoPlayStream2;
        }
        for (UGCVideoPlayStream uGCVideoPlayStream4 : list2) {
            if (Intrinsics.c(uGCVideoPlayStream4.getResolutions(), d11)) {
                uGCVideoPlayStream2 = uGCVideoPlayStream4;
            }
        }
        if (uGCVideoPlayStream2 == 0) {
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (f72623a.b((UGCVideoPlayStream) obj, d11)) {
                    break;
                }
            }
            uGCVideoPlayStream2 = (UGCVideoPlayStream) obj;
        }
        if (uGCVideoPlayStream2 == 0) {
            uGCVideoPlayStream2 = CollectionsKt.u0(list);
        }
        if (f72624b.length() == 0 && (uGCVideoPlayStream = uGCVideoPlayStream2) != null) {
            f72623a.e(uGCVideoPlayStream.getResolutions());
        }
        UGCVideoPlayStream uGCVideoPlayStream5 = uGCVideoPlayStream2;
        a.C0856a.f(lg.a.f68962a, "UGCResolutionHelper", "getMp4DefaultPlayBean, bean.resolutions： " + (uGCVideoPlayStream5 != null ? uGCVideoPlayStream5.getResolutions() : null), false, 4, null);
        return uGCVideoPlayStream5;
    }

    public final UGCVideoPlayStream a(UGCVideoPlayInfo uGCVideoPlayInfo) {
        List<UGCVideoPlayStream> resources = uGCVideoPlayInfo != null ? uGCVideoPlayInfo.getResources() : null;
        if (resources == null || resources.isEmpty()) {
            return null;
        }
        return uGCVideoPlayInfo.getResources().size() == 1 ? (UGCVideoPlayStream) CollectionsKt.i0(uGCVideoPlayInfo.getResources()) : c(uGCVideoPlayInfo.getResources());
    }

    public final String d() {
        String str = f72624b;
        if (str.length() == 0) {
            str = com.transsion.baselib.report.launch.b.f43424a.b().getString("key_stream_resolution", "480");
            if (str == null) {
                str = "480";
            }
            f72624b = str;
        }
        return str;
    }

    public final void e(String resolution) {
        Intrinsics.h(resolution, "resolution");
        a.C0856a.f(lg.a.f68962a, "UGCResolutionHelper", "save, resolution： " + resolution, false, 4, null);
        f72624b = resolution;
        com.transsion.baselib.report.launch.b.f43424a.b().putString("key_stream_resolution", resolution);
    }
}
