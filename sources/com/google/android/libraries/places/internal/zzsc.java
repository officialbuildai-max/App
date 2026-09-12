package com.google.android.libraries.places.internal;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzsc {
    public static final /* synthetic */ int zza = 0;
    private static final zzob zzb = zzob.zzn("http", "https", "mailto", "ftp");
    private static final zzob zzc = zzob.zzp("audio/3gpp2", MimeTypes.AUDIO_AMR_NB, "audio/aac", "audio/midi", "audio/mp3", MimeTypes.AUDIO_MP4, MimeTypes.AUDIO_MPEG, "audio/oga", "audio/ogg", MimeTypes.AUDIO_OPUS, "audio/x-m4a", "audio/x-matroska", "audio/x-wav", "audio/wav", MimeTypes.AUDIO_WEBM, "image/bmp", "image/gif", "image/jpeg", "image/jpg", "image/png", "image/svg+xml", "image/tiff", "image/webp", "image/x-icon", MimeTypes.VIDEO_MPEG, MimeTypes.VIDEO_MP4, "video/ogg", MimeTypes.VIDEO_WEBM, "video/x-matroska", "font/ttf");
    private static final zzob zzd = zzob.zzk();

    public static zzsb zza(String str, zzsb zzsbVar) {
        char charAt;
        int i11;
        char charAt2;
        char charAt3;
        zzob zzobVar = zzd;
        String zza2 = zzlu.zza(str);
        zzox it = zzb.iterator();
        while (true) {
            if (!it.hasNext()) {
                if (zza2.startsWith("data:")) {
                    String zza3 = zzlu.zza(str);
                    if (zza3.startsWith("data:") && zza3.length() > 5) {
                        int i12 = 5;
                        while (i12 < zza3.length() && (charAt3 = zza3.charAt(i12)) != ';' && charAt3 != ',') {
                            i12++;
                        }
                        if (zzc.contains(zza3.substring(5, i12)) && zza3.startsWith(";base64,", i12) && (i11 = i12 + 8) < zza3.length()) {
                            while (i11 < zza3.length() && (charAt2 = zza3.charAt(i11)) != '=') {
                                if ((charAt2 < 'a' || charAt2 > 'z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '/')) {
                                    break;
                                }
                                i11++;
                            }
                            while (i11 < zza3.length()) {
                                if (zza3.charAt(i11) == '=') {
                                    i11++;
                                }
                            }
                        }
                    }
                    return zzsbVar;
                }
                Iterator it2 = zzobVar.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (zza2.startsWith(String.valueOf(zzlu.zza(((zzry) it2.next()).name()).replace('_', '-')).concat(":"))) {
                            break;
                        }
                    } else {
                        for (int i13 = 0; i13 < str.length() && (charAt = str.charAt(i13)) != '#' && charAt != '/'; i13++) {
                            if (charAt != ':') {
                                if (charAt == '?') {
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                if (zza2.startsWith(String.valueOf((String) it.next()).concat(":"))) {
                    break;
                }
            }
        }
        return new zzsb(str);
    }
}
