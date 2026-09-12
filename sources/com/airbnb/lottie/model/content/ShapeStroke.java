package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import java.util.List;
import m4.t;
import q4.b;
import q4.d;
import r4.c;

/* loaded from: classes.dex */
public class ShapeStroke implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f17884a;

    /* renamed from: b, reason: collision with root package name */
    private final b f17885b;

    /* renamed from: c, reason: collision with root package name */
    private final List f17886c;

    /* renamed from: d, reason: collision with root package name */
    private final q4.a f17887d;

    /* renamed from: e, reason: collision with root package name */
    private final d f17888e;

    /* renamed from: f, reason: collision with root package name */
    private final b f17889f;

    /* renamed from: g, reason: collision with root package name */
    private final LineCapType f17890g;

    /* renamed from: h, reason: collision with root package name */
    private final LineJoinType f17891h;

    /* renamed from: i, reason: collision with root package name */
    private final float f17892i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f17893j;

    /* loaded from: classes.dex */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i11 = a.f17894a[ordinal()];
            return i11 != 1 ? i11 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* loaded from: classes.dex */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i11 = a.f17895b[ordinal()];
            if (i11 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i11 == 2) {
                return Paint.Join.MITER;
            }
            if (i11 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17894a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f17895b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f17895b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17895b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17895b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f17894a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17894a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17894a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, b bVar, List list, q4.a aVar, d dVar, b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f11, boolean z10) {
        this.f17884a = str;
        this.f17885b = bVar;
        this.f17886c = list;
        this.f17887d = aVar;
        this.f17888e = dVar;
        this.f17889f = bVar2;
        this.f17890g = lineCapType;
        this.f17891h = lineJoinType;
        this.f17892i = f11;
        this.f17893j = z10;
    }

    @Override // r4.c
    public m4.c a(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new t(lottieDrawable, aVar, this);
    }

    public LineCapType b() {
        return this.f17890g;
    }

    public q4.a c() {
        return this.f17887d;
    }

    public b d() {
        return this.f17885b;
    }

    public LineJoinType e() {
        return this.f17891h;
    }

    public List f() {
        return this.f17886c;
    }

    public float g() {
        return this.f17892i;
    }

    public String h() {
        return this.f17884a;
    }

    public d i() {
        return this.f17888e;
    }

    public b j() {
        return this.f17889f;
    }

    public boolean k() {
        return this.f17893j;
    }
}
