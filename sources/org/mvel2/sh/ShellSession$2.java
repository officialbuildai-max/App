package org.mvel2.sh;

import java.io.OutputStream;
import java.io.PrintStream;
import org.mvel2.sh.a;

/* loaded from: classes7.dex */
class ShellSession$2 implements Runnable {
    final /* synthetic */ a this$0;
    final /* synthetic */ OutputStream val$outStream;
    final /* synthetic */ Process val$p;
    final /* synthetic */ a.C0902a val$runState;
    final /* synthetic */ PrintStream val$sysPrintStream;

    ShellSession$2(a aVar, a.C0902a c0902a, OutputStream outputStream, Process process, PrintStream printStream) {
        this.this$0 = aVar;
        this.val$outStream = outputStream;
        this.val$p = process;
        this.val$sysPrintStream = printStream;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread = new Thread(new Runnable() { // from class: org.mvel2.sh.ShellSession$2.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ShellSession$2.this.getClass();
                    throw null;
                } catch (Exception unused) {
                }
            }
        });
        thread.setPriority(1);
        thread.start();
        try {
            this.val$p.waitFor();
        } catch (InterruptedException unused) {
        }
        this.val$sysPrintStream.flush();
        throw null;
    }
}
