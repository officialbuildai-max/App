package com.transsion.baseui.music;

import android.text.TextUtils;
import com.google.common.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class MusicReport {

    /* renamed from: a, reason: collision with root package name */
    public static final MusicReport f43527a = new MusicReport();

    private MusicReport() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List b() {
        String string = com.transsion.baselib.report.launch.b.f43424a.b().getString("music_play_duration", "");
        if (TextUtils.isEmpty(string)) {
            return new ArrayList();
        }
        Type type = new TypeToken<List<n>>() { // from class: com.transsion.baseui.music.MusicReport$getLocalHistoryList$personListType$1
        }.getType();
        Intrinsics.g(type, "getType(...)");
        Object e11 = com.blankj.utilcode.util.o.e(string, type);
        Intrinsics.e(e11);
        return (List) e11;
    }

    public final void c() {
        Object m1185constructorimpl;
        List<n> b11;
        try {
            Result.Companion companion = Result.INSTANCE;
            b11 = f43527a.b();
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (b11.isEmpty()) {
            return;
        }
        for (n nVar : b11) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("subject_id", String.valueOf(nVar.h()));
            linkedHashMap.put("trace_id", String.valueOf(nVar.d()));
            linkedHashMap.put("ops", String.valueOf(nVar.e()));
            linkedHashMap.put("play_duration", String.valueOf(nVar.f()));
            linkedHashMap.put("total_duration", String.valueOf(nVar.i()));
            linkedHashMap.put("video_bitrate", String.valueOf(nVar.j()));
            linkedHashMap.put("audio_bitrate", String.valueOf(nVar.a()));
            linkedHashMap.put("float_play_duration", String.valueOf(nVar.b()));
            linkedHashMap.put("in_bg_play_duration", String.valueOf(nVar.c()));
            hj.i.f64628a.H("music_play", "music_play", nVar.f(), linkedHashMap);
            com.transsion.player.mediasession.i.f48462a.a("MusicReport --> report() --> 上报播放时长 = " + linkedHashMap);
            com.transsion.baselib.report.launch.b.f43424a.b().remove("music_play_duration");
        }
        m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        com.transsion.player.mediasession.i.f48462a.b("MusicReport --> report() --> it = " + m1188exceptionOrNullimpl);
    }

    public final void d(n musicPlayDurationBean) {
        Intrinsics.h(musicPlayDurationBean, "musicPlayDurationBean");
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new MusicReport$saveLocal$1(musicPlayDurationBean, null), 3, null);
    }
}
