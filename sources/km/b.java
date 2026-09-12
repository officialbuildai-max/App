package km;

import com.transsion.lib_web.download_render.c;
import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.task.compare.CompareRequest;
import com.transsion.lib_web.download_render.task.compare.CompareResponse;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface b {

    /* loaded from: classes6.dex */
    public interface a {
        CompareResponse a(CompareRequest compareRequest);
    }

    /* renamed from: km.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0839b {
        public static FileData a(b bVar, FileData remoteFileData) {
            Intrinsics.h(remoteFileData, "remoteFileData");
            return c.f46221a.e(remoteFileData);
        }
    }

    CompareResponse a(CompareRequest compareRequest, a aVar);
}
