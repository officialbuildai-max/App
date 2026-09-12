package jm;

import com.transsion.lib_web.download_render.data.PageData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes6.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    private final long f66352a;

    /* renamed from: b, reason: collision with root package name */
    private final PageData f66353b;

    /* renamed from: c, reason: collision with root package name */
    private final String f66354c;

    /* renamed from: d, reason: collision with root package name */
    private final km.a f66355d;

    /* renamed from: e, reason: collision with root package name */
    private final List f66356e;

    public c(long j11, PageData pageData) {
        Intrinsics.h(pageData, "pageData");
        this.f66352a = j11;
        this.f66353b = pageData;
        this.f66354c = "DR_FileDownloadTask";
        this.f66355d = new km.a(CollectionsKt.o(new lm.b(), new lm.a()), 0, 2, null);
        this.f66356e = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b(Ref.BooleanRef booleanRef, Ref.IntRef intRef, Ref.LongRef longRef, boolean z10, String loadingUrl, int i11, long j11) {
        Intrinsics.h(loadingUrl, "loadingUrl");
        com.transsion.lib_web.download_render.utils.a.f46239a.m(loadingUrl);
        booleanRef.element = z10;
        intRef.element = i11;
        longRef.element = j11;
        return Unit.f67184a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004c, code lost:
    
        if (r2 == null) goto L15;
     */
    @Override // jm.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void start() {
        /*
            Method dump skipped, instructions count: 536
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jm.c.start():void");
    }
}
