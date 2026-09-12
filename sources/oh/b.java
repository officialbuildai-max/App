package oh;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes4.dex */
public abstract class b {
    public static final String a(long j11, int i11) {
        if (j11 < 0) {
            return "";
        }
        if (j11 < 1024) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String format = String.format(Locale.ENGLISH, "%." + i11 + "fB", Arrays.copyOf(new Object[]{Double.valueOf(j11)}, 1));
            Intrinsics.g(format, "format(...)");
            return format;
        }
        if (j11 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f67412a;
            String format2 = String.format(Locale.ENGLISH, "%." + i11 + "fKB", Arrays.copyOf(new Object[]{Double.valueOf(j11 / 1024)}, 1));
            Intrinsics.g(format2, "format(...)");
            return format2;
        }
        if (j11 < 1073741824) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.f67412a;
            String format3 = String.format(Locale.ENGLISH, "%." + i11 + "fMB", Arrays.copyOf(new Object[]{Double.valueOf(j11 / 1048576)}, 1));
            Intrinsics.g(format3, "format(...)");
            return format3;
        }
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.f67412a;
        String format4 = String.format(Locale.ENGLISH, "%." + i11 + "fGB", Arrays.copyOf(new Object[]{Double.valueOf(j11 / 1073741824)}, 1));
        Intrinsics.g(format4, "format(...)");
        return format4;
    }

    public static final String b(long j11, int i11, int i12) {
        if (j11 < 0) {
            return "";
        }
        if (j11 < 1024) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String format = String.format(Locale.ENGLISH, "%." + i12 + "fB", Arrays.copyOf(new Object[]{Double.valueOf(j11)}, 1));
            Intrinsics.g(format, "format(...)");
            return format;
        }
        if (j11 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f67412a;
            String format2 = String.format(Locale.ENGLISH, "%." + i12 + "fKB", Arrays.copyOf(new Object[]{Double.valueOf(j11 / 1024)}, 1));
            Intrinsics.g(format2, "format(...)");
            return format2;
        }
        if (j11 < 1073741824) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.f67412a;
            String format3 = String.format(Locale.ENGLISH, "%." + i11 + "fMB", Arrays.copyOf(new Object[]{Double.valueOf(j11 / 1048576)}, 1));
            Intrinsics.g(format3, "format(...)");
            return format3;
        }
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.f67412a;
        String format4 = String.format(Locale.ENGLISH, "%." + i11 + "fGB", Arrays.copyOf(new Object[]{Double.valueOf(j11 / 1073741824)}, 1));
        Intrinsics.g(format4, "format(...)");
        return format4;
    }
}
