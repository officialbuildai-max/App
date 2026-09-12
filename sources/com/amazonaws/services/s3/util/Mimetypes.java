package com.amazonaws.services.s3.util;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.StringUtils;
import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.cloud.tmc.integration.utils.share.config.ShareConstant;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.entity.b;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class Mimetypes {

    /* renamed from: b, reason: collision with root package name */
    private static final Log f19057b = LogFactory.b(Mimetypes.class);

    /* renamed from: c, reason: collision with root package name */
    private static Mimetypes f19058c = null;

    /* renamed from: a, reason: collision with root package name */
    private final HashMap f19059a;

    Mimetypes() {
        HashMap hashMap = new HashMap();
        this.f19059a = hashMap;
        hashMap.put(RecorderConstants.FORMAT_3GP, MimeTypes.VIDEO_H263);
        hashMap.put("ai", "application/postscript");
        hashMap.put("aif", "audio/x-aiff");
        hashMap.put("aifc", "audio/x-aiff");
        hashMap.put("aiff", "audio/x-aiff");
        hashMap.put("asc", ShareConstant.SHARE_TYPE_TEXT);
        hashMap.put("atom", "application/atom+xml");
        hashMap.put("au", "audio/basic");
        hashMap.put("avi", "video/x-msvideo");
        hashMap.put("bcpio", "application/x-bcpio");
        hashMap.put("bin", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        hashMap.put("bmp", "image/bmp");
        hashMap.put("cdf", "application/x-netcdf");
        hashMap.put("cgm", "image/cgm");
        hashMap.put("class", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        hashMap.put("cpio", "application/x-cpio");
        hashMap.put("cpt", "application/mac-compactpro");
        hashMap.put("csh", "application/x-csh");
        hashMap.put("css", "text/css");
        hashMap.put(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_CURRENT_RATE, "application/x-director");
        hashMap.put("dif", "video/x-dv");
        hashMap.put(OfflineConstantsKt.OFFLINE_DOWNLOAD_SEARCH_MODE_DIR, "application/x-director");
        hashMap.put("djv", "image/vnd.djvu");
        hashMap.put("djvu", "image/vnd.djvu");
        hashMap.put("dll", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        hashMap.put("dmg", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        hashMap.put("dms", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        hashMap.put("doc", "application/msword");
        hashMap.put("dtd", "application/xml-dtd");
        hashMap.put("dv", "video/x-dv");
        hashMap.put("dvi", "application/x-dvi");
        hashMap.put("dxr", "application/x-director");
        hashMap.put("eps", "application/postscript");
        hashMap.put("etx", "text/x-setext");
        hashMap.put("exe", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        hashMap.put("ez", "application/andrew-inset");
        hashMap.put("flv", "video/x-flv");
        hashMap.put("gif", "image/gif");
        hashMap.put("gram", "application/srgs");
        hashMap.put("grxml", "application/srgs+xml");
        hashMap.put("gtar", "application/x-gtar");
        hashMap.put("gz", "application/x-gzip");
        hashMap.put("hdf", "application/x-hdf");
        hashMap.put("hqx", "application/mac-binhex40");
        hashMap.put("htm", "text/html");
        hashMap.put("html", "text/html");
        hashMap.put("ice", "x-conference/x-cooltalk");
        hashMap.put("ico", "image/x-icon");
        hashMap.put("ics", "text/calendar");
        hashMap.put("ief", "image/ief");
        hashMap.put("ifb", "text/calendar");
        hashMap.put("iges", "model/iges");
        hashMap.put("igs", "model/iges");
        hashMap.put("jnlp", "application/x-java-jnlp-file");
        hashMap.put("jp2", "image/jp2");
        hashMap.put("jpe", "image/jpeg");
        hashMap.put("jpeg", "image/jpeg");
        hashMap.put("jpg", "image/jpeg");
        hashMap.put("js", "application/x-javascript");
        hashMap.put("kar", "audio/midi");
        hashMap.put("latex", "application/x-latex");
        hashMap.put("lha", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        hashMap.put("lzh", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        hashMap.put("m3u", "audio/x-mpegurl");
        hashMap.put(RecorderConstants.FORMAT_M4A, MimeTypes.AUDIO_AAC);
        hashMap.put("m4p", MimeTypes.AUDIO_AAC);
        hashMap.put("m4u", "video/vnd.mpegurl");
        hashMap.put("m4v", "video/x-m4v");
        hashMap.put("mac", "image/x-macpaint");
        hashMap.put("man", "application/x-troff-man");
        hashMap.put("mathml", "application/mathml+xml");
        hashMap.put("me", "application/x-troff-me");
        hashMap.put("mesh", "model/mesh");
        hashMap.put("mid", "audio/midi");
        hashMap.put("midi", "audio/midi");
        hashMap.put("mif", "application/vnd.mif");
        hashMap.put("mov", "video/quicktime");
        hashMap.put("movie", "video/x-sgi-movie");
        hashMap.put("mp2", MimeTypes.AUDIO_MPEG);
        hashMap.put("mp3", MimeTypes.AUDIO_MPEG);
        hashMap.put("mp4", MimeTypes.VIDEO_MP4);
        hashMap.put("mpe", MimeTypes.VIDEO_MPEG);
        hashMap.put("mpeg", MimeTypes.VIDEO_MPEG);
        hashMap.put("mpg", MimeTypes.VIDEO_MPEG);
        hashMap.put("mpga", MimeTypes.AUDIO_MPEG);
        hashMap.put("ms", "application/x-troff-ms");
        hashMap.put("msh", "model/mesh");
        hashMap.put("mxu", "video/vnd.mpegurl");
        hashMap.put(ResourceManager.KEY_MD5CHECK, "application/x-netcdf");
        hashMap.put("oda", "application/oda");
        hashMap.put("ogg", "application/ogg");
        hashMap.put("ogv", "video/ogv");
        hashMap.put("pbm", "image/x-portable-bitmap");
        hashMap.put("pct", "image/pict");
        hashMap.put("pdb", "chemical/x-pdb");
        hashMap.put("pdf", ShareConstant.SHARE_TYPE_PDF);
        hashMap.put("pgm", "image/x-portable-graymap");
        hashMap.put("pgn", "application/x-chess-pgn");
        hashMap.put("pic", "image/pict");
        hashMap.put("pict", "image/pict");
        hashMap.put("png", "image/png");
        hashMap.put("pnm", "image/x-portable-anymap");
        hashMap.put("pnt", "image/x-macpaint");
        hashMap.put("pntg", "image/x-macpaint");
        hashMap.put("ppm", "image/x-portable-pixmap");
        hashMap.put("ppt", "application/vnd.ms-powerpoint");
        hashMap.put("ps", "application/postscript");
        hashMap.put(DownloadCommon.DOWNLOAD_REPORT_QUERY_TIMEOUT, "video/quicktime");
        hashMap.put("qti", "image/x-quicktime");
        hashMap.put("qtif", "image/x-quicktime");
        hashMap.put("ra", "audio/x-pn-realaudio");
        hashMap.put("ram", "audio/x-pn-realaudio");
        hashMap.put("ras", "image/x-cmu-raster");
        hashMap.put("rdf", "application/rdf+xml");
        hashMap.put("rgb", "image/x-rgb");
        hashMap.put("rm", "application/vnd.rn-realmedia");
        hashMap.put("roff", "application/x-troff");
        hashMap.put("rtf", "text/rtf");
        hashMap.put("rtx", "text/richtext");
        hashMap.put("sgm", "text/sgml");
        hashMap.put("sgml", "text/sgml");
        hashMap.put(b.JSON_KEY_SH, "application/x-sh");
        hashMap.put("shar", "application/x-shar");
        hashMap.put("silo", "model/mesh");
        hashMap.put("sit", "application/x-stuffit");
        hashMap.put("skd", "application/x-koan");
        hashMap.put("skm", "application/x-koan");
        hashMap.put("skp", "application/x-koan");
        hashMap.put("skt", "application/x-koan");
        hashMap.put("smi", "application/smil");
        hashMap.put("smil", "application/smil");
        hashMap.put("snd", "audio/basic");
        hashMap.put("so", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        hashMap.put("spl", "application/x-futuresplash");
        hashMap.put("src", "application/x-wais-source");
        hashMap.put("sv4cpio", "application/x-sv4cpio");
        hashMap.put("sv4crc", "application/x-sv4crc");
        hashMap.put("svg", "image/svg+xml");
        hashMap.put("swf", "application/x-shockwave-flash");
        hashMap.put("t", "application/x-troff");
        hashMap.put("tar", "application/x-tar");
        hashMap.put("tcl", "application/x-tcl");
        hashMap.put("tex", "application/x-tex");
        hashMap.put("texi", "application/x-texinfo");
        hashMap.put("texinfo", "application/x-texinfo");
        hashMap.put("tif", "image/tiff");
        hashMap.put("tiff", "image/tiff");
        hashMap.put("tr", "application/x-troff");
        hashMap.put("tsv", "text/tab-separated-values");
        hashMap.put("txt", ShareConstant.SHARE_TYPE_TEXT);
        hashMap.put("ustar", "application/x-ustar");
        hashMap.put("vcd", "application/x-cdlink");
        hashMap.put("vrml", "model/vrml");
        hashMap.put("vxml", "application/voicexml+xml");
        hashMap.put(RecorderConstants.FORMAT_WAV, "audio/x-wav");
        hashMap.put("wbmp", "image/vnd.wap.wbmp");
        hashMap.put("wbxml", "application/vnd.wap.wbxml");
        hashMap.put("webm", MimeTypes.VIDEO_WEBM);
        hashMap.put("wml", "text/vnd.wap.wml");
        hashMap.put("wmlc", "application/vnd.wap.wmlc");
        hashMap.put("wmls", "text/vnd.wap.wmlscript");
        hashMap.put("wmlsc", "application/vnd.wap.wmlscriptc");
        hashMap.put("wmv", "video/x-ms-wmv");
        hashMap.put("wrl", "model/vrml");
        hashMap.put("xbm", "image/x-xbitmap");
        hashMap.put("xht", "application/xhtml+xml");
        hashMap.put("xhtml", "application/xhtml+xml");
        hashMap.put("xls", "application/vnd.ms-excel");
        hashMap.put("xml", "application/xml");
        hashMap.put("xpm", "image/x-xpixmap");
        hashMap.put("xsl", "application/xml");
        hashMap.put("xslt", "application/xslt+xml");
        hashMap.put("xul", "application/vnd.mozilla.xul+xml");
        hashMap.put("xwd", "image/x-xwindowdump");
        hashMap.put("xyz", "chemical/x-xyz");
        hashMap.put("zip", "application/zip");
    }

    public static synchronized Mimetypes a() {
        synchronized (Mimetypes.class) {
            try {
                Mimetypes mimetypes = f19058c;
                if (mimetypes != null) {
                    return mimetypes;
                }
                f19058c = new Mimetypes();
                if (f19057b.b()) {
                    HashMap hashMap = f19058c.f19059a;
                    for (String str : hashMap.keySet()) {
                        f19057b.a("Setting mime type for extension '" + str + "' to '" + ((String) hashMap.get(str)) + "'");
                    }
                }
                return f19058c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String b(File file) {
        return c(file.getName());
    }

    public String c(String str) {
        int i11;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf <= 0 || (i11 = lastIndexOf + 1) >= str.length()) {
            Log log = f19057b;
            if (log.b()) {
                log.a("File name has no extension, mime type cannot be recognised for: " + str);
            }
        } else {
            String b11 = StringUtils.b(str.substring(i11));
            if (this.f19059a.containsKey(b11)) {
                String str2 = (String) this.f19059a.get(b11);
                Log log2 = f19057b;
                if (log2.b()) {
                    log2.a("Recognised extension '" + b11 + "', mimetype is: '" + str2 + "'");
                }
                return str2;
            }
            Log log3 = f19057b;
            if (log3.b()) {
                log3.a("Extension '" + b11 + "' is unrecognized in mime type listing, using default mime type: '" + OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE + "'");
            }
        }
        return OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
    }
}
