package jp;

import android.content.ContentResolver;
import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f66375a;

    /* renamed from: b, reason: collision with root package name */
    private ContentResolver f66376b;

    public c(Context context) {
        Intrinsics.h(context, "context");
        this.f66375a = context;
        this.f66376b = context.getContentResolver();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00eb, code lost:
    
        if (r3 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ed, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00f9, code lost:
    
        r0 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0102, code lost:
    
        r3 = new java.lang.StringBuilder();
        r3.append("size:");
        r3.append(r12);
        r3.append(",duration:");
        r3.append(r14);
        r3.append(",path:");
        r3.append(r4);
        r3.append(",thumbPath:");
        r3.append(r0);
        r6 = r10.getLong(7);
        r5 = r10.getLong(8);
        r3 = new com.transsion.publish.api.VsMediaInfo();
        r3.setVideoDuration(r14);
        r3.setVideoTitle(r11);
        r3.setVideoPath(r4);
        r3.setVideoSize(r12);
        r3.setImagePath(r0);
        r3.setHeight((int) r6);
        r3.setWidth((int) r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0156, code lost:
    
        if (r25.isDisposed() != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0158, code lost:
    
        r25.onNext(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x015b, code lost:
    
        r0 = true;
        r3 = 3;
        r4 = 2;
        r5 = 1;
        r6 = 0;
        r7 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0163, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0166, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ff, code lost:
    
        if (r3 == null) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(io.reactivex.rxjava3.core.k r25) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.c.a(io.reactivex.rxjava3.core.k):void");
    }
}
