package com.transsion.player.mediasession;

import android.content.BroadcastReceiver;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/transsion/player/mediasession/MusicIntentReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "", "a", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "LibPlayer_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class MusicIntentReceiver extends BroadcastReceiver {
    private final String a() {
        String simpleName = MusicIntentReceiver.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.h(r5, r0)
            java.lang.String r5 = "intent"
            kotlin.jvm.internal.Intrinsics.h(r6, r5)
            kotlin.Result$Companion r5 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L33
            java.lang.String r5 = r6.getAction()     // Catch: java.lang.Throwable -> L33
            if (r5 == 0) goto Lbc
            int r0 = r5.hashCode()     // Catch: java.lang.Throwable -> L33
            r1 = 1997055314(0x7708a552, float:2.7715057E33)
            if (r0 == r1) goto L1d
            goto Lbc
        L1d:
            java.lang.String r0 = "android.intent.action.MEDIA_BUTTON"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> L33
            if (r5 == 0) goto Lbc
            android.os.Bundle r5 = r6.getExtras()     // Catch: java.lang.Throwable -> L33
            r6 = 0
            if (r5 == 0) goto L36
            java.lang.String r0 = "android.intent.extra.KEY_EVENT"
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Throwable -> L33
            goto L37
        L33:
            r5 = move-exception
            goto Lc3
        L36:
            r5 = r6
        L37:
            boolean r0 = r5 instanceof android.view.KeyEvent     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L3e
            android.view.KeyEvent r5 = (android.view.KeyEvent) r5     // Catch: java.lang.Throwable -> L33
            goto L3f
        L3e:
            r5 = r6
        L3f:
            if (r5 == 0) goto Lbe
            com.transsion.player.mediasession.i r0 = com.transsion.player.mediasession.i.f48462a     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = r4.a()     // Catch: java.lang.Throwable -> L33
            int r2 = r5.getKeyCode()     // Catch: java.lang.Throwable -> L33
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33
            r3.<init>()     // Catch: java.lang.Throwable -> L33
            r3.append(r1)     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = " --> onReceive --> 接收到通知点击事件, = "
            r3.append(r1)     // Catch: java.lang.Throwable -> L33
            r3.append(r5)     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = ", "
            r3.append(r1)     // Catch: java.lang.Throwable -> L33
            r3.append(r2)     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L33
            r0.a(r1)     // Catch: java.lang.Throwable -> L33
            int r5 = r5.getKeyCode()     // Catch: java.lang.Throwable -> L33
            r0 = 126(0x7e, float:1.77E-43)
            if (r5 == r0) goto Lae
            r0 = 127(0x7f, float:1.78E-43)
            if (r5 == r0) goto La0
            switch(r5) {
                case 86: goto L94;
                case 87: goto L88;
                case 88: goto L7c;
                default: goto L79;
            }     // Catch: java.lang.Throwable -> L33
        L79:
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L33
            goto Lbe
        L7c:
            com.transsion.player.mediasession.MediaBrowserCompatHelper$a r5 = com.transsion.player.mediasession.MediaBrowserCompatHelper.f48435h     // Catch: java.lang.Throwable -> L33
            com.transsion.player.mediasession.MediaBrowserCompatHelper r5 = r5.a()     // Catch: java.lang.Throwable -> L33
            r5.z()     // Catch: java.lang.Throwable -> L33
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L33
            goto Lbe
        L88:
            com.transsion.player.mediasession.MediaBrowserCompatHelper$a r5 = com.transsion.player.mediasession.MediaBrowserCompatHelper.f48435h     // Catch: java.lang.Throwable -> L33
            com.transsion.player.mediasession.MediaBrowserCompatHelper r5 = r5.a()     // Catch: java.lang.Throwable -> L33
            r5.x()     // Catch: java.lang.Throwable -> L33
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L33
            goto Lbe
        L94:
            ko.l0 r5 = ko.l0.f67091a     // Catch: java.lang.Throwable -> L33
            com.transsion.player.orplayer.g r5 = r5.h()     // Catch: java.lang.Throwable -> L33
            if (r5 == 0) goto Lbe
            r5.stop()     // Catch: java.lang.Throwable -> L33
            goto L79
        La0:
            ko.l0 r5 = ko.l0.f67091a     // Catch: java.lang.Throwable -> L33
            com.transsion.player.orplayer.g r5 = r5.h()     // Catch: java.lang.Throwable -> L33
            if (r5 == 0) goto Lbe
            r5.pause()     // Catch: java.lang.Throwable -> L33
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L33
            goto Lbe
        Lae:
            ko.l0 r5 = ko.l0.f67091a     // Catch: java.lang.Throwable -> L33
            com.transsion.player.orplayer.g r5 = r5.h()     // Catch: java.lang.Throwable -> L33
            if (r5 == 0) goto Lbe
            r5.play()     // Catch: java.lang.Throwable -> L33
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L33
            goto Lbe
        Lbc:
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L33
        Lbe:
            java.lang.Object r5 = kotlin.Result.m1185constructorimpl(r6)     // Catch: java.lang.Throwable -> L33
            goto Lcd
        Lc3:
            kotlin.Result$Companion r6 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.ResultKt.a(r5)
            java.lang.Object r5 = kotlin.Result.m1185constructorimpl(r5)
        Lcd:
            java.lang.Throwable r5 = kotlin.Result.m1188exceptionOrNullimpl(r5)
            if (r5 != 0) goto Ld4
            goto Lf1
        Ld4:
            com.transsion.player.mediasession.i r6 = com.transsion.player.mediasession.i.f48462a
            java.lang.String r0 = r4.a()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " --> onReceive --> 接收到通知点击事件 --- it = "
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r6.a(r5)
        Lf1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.player.mediasession.MusicIntentReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
