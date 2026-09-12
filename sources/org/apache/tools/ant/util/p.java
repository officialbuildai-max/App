package org.apache.tools.ant.util;

import android.support.v4.media.session.PlaybackStateCompat;

/* loaded from: classes7.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final String f71726a = System.getProperty("line.separator");

    public static long a(String str) {
        long j11;
        char charAt = str.charAt(0);
        int i11 = 1;
        long j12 = 1;
        if (charAt == '+') {
            str = str.substring(1);
        } else if (charAt == '-') {
            str = str.substring(1);
            j12 = -1;
        }
        char charAt2 = str.charAt(str.length() - 1);
        if (!Character.isDigit(charAt2)) {
            if (charAt2 == 'G') {
                j11 = 1073741824;
            } else if (charAt2 == 'K') {
                j11 = 1024;
            } else if (charAt2 == 'M') {
                j11 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            } else if (charAt2 == 'P') {
                j11 = 1125899906842624L;
            } else if (charAt2 != 'T') {
                i11 = 0;
                str = str.substring(0, str.length() - i11);
            } else {
                j11 = 1099511627776L;
            }
            j12 *= j11;
            str = str.substring(0, str.length() - i11);
        }
        return j12 * Long.parseLong(str);
    }
}
