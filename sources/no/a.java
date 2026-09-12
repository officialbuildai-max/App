package no;

import android.view.View;
import com.transsion.player.ui.render.RenderScaleMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private int f70611a;

    /* renamed from: b, reason: collision with root package name */
    private int f70612b;

    /* renamed from: c, reason: collision with root package name */
    private RenderScaleMode f70613c = RenderScaleMode.SCREEN_SCALE_DEFAULT;

    /* renamed from: d, reason: collision with root package name */
    private int f70614d;

    /* renamed from: no.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public /* synthetic */ class C0880a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f70615a;

        static {
            int[] iArr = new int[RenderScaleMode.values().length];
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_ORIGINAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_16_9.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_4_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_MATCH_PARENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f70615a = iArr;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0029. Please report as an issue. */
    public final int[] a(int i11, int i12) {
        int i13 = this.f70614d;
        if (i13 == 90 || i13 == 270) {
            i12 = i11;
            i11 = i12;
        }
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        if (this.f70612b == 0 || this.f70611a == 0) {
            return new int[]{size, size2};
        }
        switch (C0880a.f70615a[this.f70613c.ordinal()]) {
            case 1:
                int i14 = this.f70611a;
                int i15 = i14 * size2;
                int i16 = this.f70612b;
                if (i15 < size * i16) {
                    i11 = (i14 * size2) / i16;
                } else {
                    if (i14 * size2 > size * i16) {
                        i12 = (i16 * size) / i14;
                        i11 = size;
                        return new int[]{i11, i12};
                    }
                    i11 = size;
                }
                i12 = size2;
                return new int[]{i11, i12};
            case 2:
                i11 = this.f70611a;
                i12 = this.f70612b;
                return new int[]{i11, i12};
            case 3:
                i12 = (size / 16) * 9;
                if (size2 <= i12) {
                    i11 = (size2 / 9) * 16;
                    i12 = size2;
                    return new int[]{i11, i12};
                }
                i11 = size;
                return new int[]{i11, i12};
            case 4:
                i12 = (size / 4) * 3;
                if (size2 <= i12) {
                    i11 = (size2 / 3) * 4;
                    i12 = size2;
                    return new int[]{i11, i12};
                }
                i11 = size;
                return new int[]{i11, i12};
            case 5:
                return new int[]{i11, i12};
            case 6:
                int i17 = this.f70611a;
                int i18 = i17 * size2;
                int i19 = this.f70612b;
                if (i18 > size * i19) {
                    i11 = (i17 * size2) / i19;
                    i12 = size2;
                    return new int[]{i11, i12};
                }
                i12 = (i19 * size) / i17;
                i11 = size;
                return new int[]{i11, i12};
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void b(RenderScaleMode screenScale) {
        Intrinsics.h(screenScale, "screenScale");
        if (screenScale == this.f70613c) {
            return;
        }
        this.f70613c = screenScale;
    }

    public final void c(int i11) {
        this.f70614d = i11;
    }

    public final void d(int i11, int i12) {
        this.f70611a = i11;
        this.f70612b = i12;
    }
}
