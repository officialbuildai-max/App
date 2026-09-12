package org.mvel2.sh;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import org.mvel2.sh.a;
import r10.d;

/* loaded from: classes7.dex */
class ShellSession$1 implements Runnable {
    final /* synthetic */ a this$0;
    final /* synthetic */ InputStream val$inStream;
    final /* synthetic */ a.C0902a val$runState;
    final /* synthetic */ PrintStream val$sysPrintStream;

    ShellSession$1(a aVar, InputStream inputStream, PrintStream printStream, a.C0902a c0902a) {
        this.this$0 = aVar;
        this.val$inStream = inputStream;
        this.val$sysPrintStream = printStream;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z10;
        PrintStream printStream;
        int i11;
        int i12;
        Map map;
        Map map2;
        PrintStream printStream2;
        String str;
        byte[] bArr = new byte[25];
        while (true) {
            try {
                int read = this.val$inStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                for (int i13 = 0; i13 < read; i13++) {
                    this.val$sysPrintStream.print((char) bArr[i13]);
                }
                this.val$sysPrintStream.flush();
            } catch (Exception unused) {
                this.val$sysPrintStream.flush();
                z10 = this.this$0.f72138g;
                if (z10) {
                    printStream = this.this$0.f72140i;
                    PrintStream append = printStream.append((CharSequence) ">");
                    a aVar = this.this$0;
                    i11 = aVar.f72139h;
                    i12 = this.this$0.f72137f;
                    append.append((CharSequence) aVar.j((i11 - 1) + (i12 * 4)));
                    return;
                }
                a aVar2 = this.this$0;
                map = aVar2.f72134c;
                String str2 = (String) map.get("$PROMPT");
                map2 = this.this$0.f72133b;
                aVar2.f72139h = aVar2.f72141j = String.valueOf(d.b(str2, map2)).length();
                printStream2 = this.this$0.f72140i;
                str = this.this$0.f72141j;
                printStream2.append((CharSequence) str);
                return;
            }
        }
        throw null;
    }
}
