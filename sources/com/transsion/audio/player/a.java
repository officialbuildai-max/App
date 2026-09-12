package com.transsion.audio.player;

import android.text.TextUtils;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.player.orplayer.PlayError;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private AudioBean f42954a;

    /* renamed from: b, reason: collision with root package name */
    private final String f42955b;

    /* renamed from: c, reason: collision with root package name */
    private long f42956c;

    /* renamed from: d, reason: collision with root package name */
    private long f42957d;

    /* renamed from: e, reason: collision with root package name */
    private long f42958e;

    /* renamed from: f, reason: collision with root package name */
    private long f42959f;

    /* renamed from: g, reason: collision with root package name */
    private int f42960g;

    /* renamed from: h, reason: collision with root package name */
    private long f42961h;

    /* renamed from: i, reason: collision with root package name */
    private long f42962i;

    /* renamed from: j, reason: collision with root package name */
    private long f42963j;

    /* renamed from: k, reason: collision with root package name */
    private int f42964k;

    /* renamed from: l, reason: collision with root package name */
    private long f42965l;

    /* renamed from: m, reason: collision with root package name */
    private long f42966m;

    /* renamed from: n, reason: collision with root package name */
    private Integer f42967n;

    public a(AudioBean audioBean) {
        Intrinsics.h(audioBean, "audioBean");
        this.f42955b = a.class.getSimpleName();
        this.f42954a = audioBean;
        this.f42956c = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, "video_play", "initView", false, 4, null);
    }

    private final void a() {
        String str;
        String str2;
        Long duration;
        String ops;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        AudioBean audioBean = this.f42954a;
        String str3 = "";
        if (audioBean == null || (str = audioBean.getPostId()) == null) {
            str = "";
        }
        linkedHashMap.put("post_id", str);
        AudioBean audioBean2 = this.f42954a;
        if (audioBean2 == null || (str2 = audioBean2.getSubjectId()) == null) {
            str2 = "";
        }
        linkedHashMap.put("subject_id", str2);
        AudioBean audioBean3 = this.f42954a;
        if (!TextUtils.isEmpty(audioBean3 != null ? audioBean3.getOps() : null)) {
            AudioBean audioBean4 = this.f42954a;
            if (audioBean4 != null && (ops = audioBean4.getOps()) != null) {
                str3 = ops;
            }
            linkedHashMap.put("ops", str3);
        }
        if (this.f42957d > 0) {
            linkedHashMap.put("is_start", "1");
            linkedHashMap.put("delay_v", String.valueOf(this.f42957d - this.f42956c));
            linkedHashMap.put("buffer_time", String.valueOf(this.f42958e));
            linkedHashMap.put("buffer_count", String.valueOf(this.f42960g));
            float f11 = (float) this.f42961h;
            AudioBean audioBean5 = this.f42954a;
            linkedHashMap.put("play_complete", String.valueOf(((f11 / ((float) ((audioBean5 == null || (duration = audioBean5.getDuration()) == null) ? 1L : duration.longValue()))) * 100.0f) + (this.f42964k * 100.0f)));
            linkedHashMap.put("play_duration", String.valueOf(this.f42963j));
            linkedHashMap.put("pause_duration", String.valueOf(this.f42966m));
        } else {
            linkedHashMap.put("is_start", "0");
            linkedHashMap.put("delay_v", String.valueOf(System.currentTimeMillis() - this.f42956c));
        }
        Integer num = this.f42967n;
        if (num != null) {
            linkedHashMap.put("error_code", String.valueOf(num));
        }
        hj.i.f64628a.H("postdetail", "audio_play", this.f42963j, linkedHashMap);
    }

    public final void b() {
        a();
    }

    public final void c() {
        if (this.f42957d > 0) {
            this.f42959f = System.currentTimeMillis();
        }
    }

    public final void d() {
        if (this.f42959f > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f42959f;
            this.f42959f = currentTimeMillis;
            this.f42958e += currentTimeMillis;
            this.f42960g++;
        }
    }

    public final void e(PlayError errorInfo) {
        Intrinsics.h(errorInfo, "errorInfo");
        this.f42967n = errorInfo.getErrorCode();
    }

    public final void f(long j11) {
        long j12 = this.f42962i;
        long j13 = j11 - j12;
        if (1 <= j13 && j13 < 1000) {
            this.f42963j += j11 - j12;
        }
        this.f42962i = j11;
        if (j11 > this.f42961h) {
            this.f42961h = j11;
        }
    }

    public final void g() {
        a.C0856a.f(lg.a.f68962a, "video_play", "onRenderFirstFrame", false, 4, null);
        if (this.f42957d > 0) {
            return;
        }
        this.f42957d = System.currentTimeMillis();
    }

    public final void h() {
        this.f42965l = System.currentTimeMillis();
    }

    public final void i() {
        if (this.f42965l != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f42965l;
            this.f42965l = currentTimeMillis;
            this.f42966m += currentTimeMillis;
        }
    }
}
