package net.typeblog.webview;

import android.content.res.XResources;

import de.robv.android.xposed.IXposedHookZygoteInit;

public class ModWebView implements IXposedHookZygoteInit
{

	@Override
	public void initZygote(IXposedHookZygoteInit.StartupParam startupParam) throws Throwable {
		XResources.setSystemWideReplacement("android", "string", "config_webViewPackageName", "com.google.android.webview");
	}

}
