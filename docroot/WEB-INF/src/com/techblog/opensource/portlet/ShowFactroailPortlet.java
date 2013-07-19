package com.techblog.opensource.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ShowFactroailPortlet extends MVCPortlet{

	private static Log log = LogFactoryUtil.getLog(ShowFactroailPortlet.class);
	
	//Default Render Method.
		public void doView(RenderRequest renderRequest,
				RenderResponse renderResponse) throws IOException, PortletException {
			String factorialNum = ParamUtil.get(renderRequest, "factorialNum", "1");
			log.info("factorialNum==>"+factorialNum);
			renderRequest.setAttribute("factorialNum",factorialNum);
			super.doView(renderRequest, renderResponse);
		}

		@ProcessAction(name="getFactorial")
		public void addName(ActionRequest actionRequest,
				ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException{
			String inputNum = ParamUtil.get(actionRequest, "number", "0");
			
			log.info("inputNum==>"+inputNum);
			
			int number = Integer.parseInt(inputNum);
			int factorialNum=1;
			
			for(int index=1;index<=number;index++){
				factorialNum = factorialNum * index;
			}
			log.info("factorialNum==>"+factorialNum);
			actionResponse.setRenderParameter("factorialNum", String.valueOf(factorialNum));
		}

}
