package i3;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class i {
    private static int a(k kVar, long j11) {
        if (j11 == C.TIME_UNSET) {
            return 0;
        }
        int nextEventTimeIndex = kVar.getNextEventTimeIndex(j11);
        if (nextEventTimeIndex == -1) {
            nextEventTimeIndex = kVar.getEventTimeCount();
        }
        return (nextEventTimeIndex <= 0 || kVar.getEventTime(nextEventTimeIndex + (-1)) != j11) ? nextEventTimeIndex : nextEventTimeIndex - 1;
    }

    private static void b(k kVar, int i11, androidx.media3.common.util.m mVar) {
        long eventTime = kVar.getEventTime(i11);
        List cues = kVar.getCues(eventTime);
        if (cues.isEmpty()) {
            return;
        }
        if (i11 == kVar.getEventTimeCount() - 1) {
            throw new IllegalStateException();
        }
        long eventTime2 = kVar.getEventTime(i11 + 1) - kVar.getEventTime(i11);
        if (eventTime2 > 0) {
            mVar.accept(new e(cues, eventTime, eventTime2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[LOOP:0: B:11:0x003d->B:13:0x0043, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(i3.k r11, i3.s.b r12, androidx.media3.common.util.m r13) {
        /*
            long r0 = r12.f65048a
            int r0 = a(r11, r0)
            long r1 = r12.f65048a
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L3b
            int r1 = r11.getEventTimeCount()
            if (r0 >= r1) goto L3b
            long r3 = r12.f65048a
            java.util.List r6 = r11.getCues(r3)
            long r3 = r11.getEventTime(r0)
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L3b
            long r7 = r12.f65048a
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 >= 0) goto L3b
            i3.e r1 = new i3.e
            long r9 = r3 - r7
            r5 = r1
            r5.<init>(r6, r7, r9)
            r13.accept(r1)
            r1 = 1
            goto L3c
        L3b:
            r1 = r2
        L3c:
            r3 = r0
        L3d:
            int r4 = r11.getEventTimeCount()
            if (r3 >= r4) goto L49
            b(r11, r3, r13)
            int r3 = r3 + 1
            goto L3d
        L49:
            boolean r3 = r12.f65049b
            if (r3 == 0) goto L76
            if (r1 == 0) goto L51
            int r0 = r0 + (-1)
        L51:
            if (r2 >= r0) goto L59
            b(r11, r2, r13)
            int r2 = r2 + 1
            goto L51
        L59:
            if (r1 == 0) goto L76
            i3.e r1 = new i3.e
            long r2 = r12.f65048a
            java.util.List r4 = r11.getCues(r2)
            long r5 = r11.getEventTime(r0)
            long r2 = r12.f65048a
            long r11 = r11.getEventTime(r0)
            long r7 = r2 - r11
            r3 = r1
            r3.<init>(r4, r5, r7)
            r13.accept(r1)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.i.c(i3.k, i3.s$b, androidx.media3.common.util.m):void");
    }
}
