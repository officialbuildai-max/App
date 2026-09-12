package g9;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.util.p0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.tools.zip.UnixStat;

/* loaded from: classes4.dex */
public final class x {

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f63597c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a, reason: collision with root package name */
    public int f63598a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f63599b = -1;

    private boolean b(String str) {
        Matcher matcher = f63597c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt((String) p0.j(matcher.group(1)), 16);
            int parseInt2 = Integer.parseInt((String) p0.j(matcher.group(2)), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f63598a = parseInt;
            this.f63599b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean a() {
        return (this.f63598a == -1 || this.f63599b == -1) ? false : true;
    }

    public boolean c(Metadata metadata) {
        for (int i11 = 0; i11 < metadata.length(); i11++) {
            Metadata.Entry entry = metadata.get(i11);
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if ("iTunSMPB".equals(commentFrame.description) && b(commentFrame.text)) {
                    return true;
                }
            } else if (entry instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) entry;
                if ("com.apple.iTunes".equals(internalFrame.domain) && "iTunSMPB".equals(internalFrame.description) && b(internalFrame.text)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean d(int i11) {
        int i12 = i11 >> 12;
        int i13 = i11 & UnixStat.PERM_MASK;
        if (i12 <= 0 && i13 <= 0) {
            return false;
        }
        this.f63598a = i12;
        this.f63599b = i13;
        return true;
    }
}
