package androidx.media3.exoplayer.offline;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.util.a1;

/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final NotificationCompat.m f12505a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {
        public static void a(NotificationCompat.m mVar) {
            mVar.w(1);
        }
    }

    public k(Context context, String str) {
        this.f12505a = new NotificationCompat.m(context.getApplicationContext(), str);
    }

    private Notification a(Context context, int i11, PendingIntent pendingIntent, String str, int i12, int i13, int i14, boolean z10, boolean z11, boolean z12) {
        this.f12505a.J(i11);
        this.f12505a.q(i12 == 0 ? null : context.getResources().getString(i12));
        this.f12505a.o(pendingIntent);
        this.f12505a.L(str != null ? new NotificationCompat.k().q(str) : null);
        this.f12505a.H(i13, i14, z10);
        this.f12505a.E(z11);
        this.f12505a.I(z12);
        if (a1.f10432a >= 31) {
            a.a(this.f12505a);
        }
        return this.f12505a.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.app.Notification b(android.content.Context r22, int r23, android.app.PendingIntent r24, java.lang.String r25, java.util.List r26, int r27) {
        /*
            r21 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r2
        La:
            int r10 = r26.size()
            if (r3 >= r10) goto L4a
            r10 = r26
            java.lang.Object r11 = r10.get(r3)
            androidx.media3.exoplayer.offline.c r11 = (androidx.media3.exoplayer.offline.c) r11
            int r12 = r11.f12496b
            if (r12 == 0) goto L46
            r13 = 2
            if (r12 == r13) goto L28
            r13 = 5
            if (r12 == r13) goto L26
            r13 = 7
            if (r12 == r13) goto L28
            goto L47
        L26:
            r7 = r2
            goto L47
        L28:
            float r4 = r11.b()
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r12 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r12 == 0) goto L34
            float r0 = r0 + r4
            r9 = r1
        L34:
            long r11 = r11.a()
            r13 = 0
            int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r4 <= 0) goto L40
            r4 = r2
            goto L41
        L40:
            r4 = r1
        L41:
            r6 = r6 | r4
            int r8 = r8 + 1
            r4 = r2
            goto L47
        L46:
            r5 = r2
        L47:
            int r3 = r3 + 1
            goto La
        L4a:
            if (r4 == 0) goto L51
            int r3 = androidx.media3.exoplayer.R$string.exo_download_downloading
        L4e:
            r15 = r3
        L4f:
            r3 = r2
            goto L6f
        L51:
            if (r5 == 0) goto L68
            if (r27 == 0) goto L68
            r3 = r27 & 2
            if (r3 == 0) goto L5e
            int r3 = androidx.media3.exoplayer.R$string.exo_download_paused_for_wifi
        L5b:
            r15 = r3
            r3 = r1
            goto L6f
        L5e:
            r3 = r27 & 1
            if (r3 == 0) goto L65
            int r3 = androidx.media3.exoplayer.R$string.exo_download_paused_for_network
            goto L5b
        L65:
            int r3 = androidx.media3.exoplayer.R$string.exo_download_paused
            goto L5b
        L68:
            if (r7 == 0) goto L6d
            int r3 = androidx.media3.exoplayer.R$string.exo_download_removing
            goto L4e
        L6d:
            r15 = r1
            goto L4f
        L6f:
            if (r3 == 0) goto L89
            r3 = 100
            if (r4 == 0) goto L84
            float r4 = (float) r8
            float r0 = r0 / r4
            int r0 = (int) r0
            if (r9 == 0) goto L7d
            if (r6 == 0) goto L7d
            r1 = r2
        L7d:
            r17 = r0
            r18 = r1
        L81:
            r16 = r3
            goto L8f
        L84:
            r17 = r1
            r18 = r2
            goto L81
        L89:
            r16 = r1
            r17 = r16
            r18 = r17
        L8f:
            r19 = 1
            r20 = 0
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r24
            r14 = r25
            android.app.Notification r0 = r10.a(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.offline.k.b(android.content.Context, int, android.app.PendingIntent, java.lang.String, java.util.List, int):android.app.Notification");
    }
}
