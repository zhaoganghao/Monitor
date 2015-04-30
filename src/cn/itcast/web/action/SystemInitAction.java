package cn.itcast.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.bean.HandlerWay;
import cn.itcast.bean.QuestionType;
import cn.itcast.bean.Rank;
import cn.itcast.bean.Source;
import cn.itcast.bean.User;
import cn.itcast.service.HandlerWayService;
import cn.itcast.service.QuestionTypeService;
import cn.itcast.service.RankService;
import cn.itcast.service.SourceService;
import cn.itcast.service.UserService;
/**
 * ��ʼ�� (��action����ϵͳ��װ����ִ��)
 */
@Controller("/system/init")
public class SystemInitAction extends Action {
	@Resource SourceService sourceService;
	@Resource QuestionTypeService questionTypeService;
	@Resource UserService userService;
	@Resource RankService rankService;
	@Resource HandlerWayService handlerWayService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		initAdmin();
		this.initQuestionType();
		this.initRank();
		this.initSource();
		this.initHandlerWay();
		request.setAttribute("message", "��ʼ�����");
		request.setAttribute("urladdress", "/login.do");
		return mapping.findForward("message");
	}
	/**
	 * ��ʼ������Ա�˺�
	 */
	private void initAdmin() {
		if(userService.getCount()==0){
			User user = new User("admin","admin");
			user.setType(1);
			userService.update(user);
		}		
	}
	/**
	 * ��ʼ��ϵͳȨ����
	 */
	private void initSource() {
		if(sourceService.getCount()==0){
			Source source1=new Source(1,"����");
			Source source2=new Source(2,"����");
			Source source3=new Source(3,"����");
			Source source4=new Source(4,"����ٱ�");
			Source source5=new Source(5,"����");
			sourceService.update(source1);
			sourceService.update(source2);
			sourceService.update(source3);
			sourceService.update(source4);
			sourceService.update(source5);
		}	
	}
	private void initRank() {
		if(rankService.getCount()==0){
			Rank rank1=new Rank(1,"ʡ����������");
			Rank rank2=new Rank(2,"������");
			Rank rank3=new Rank(3,"�ش���");
			Rank rank4=new Rank(4,"��Ƽ�");
			Rank rank5=new Rank(5,"һ��ɲ�");
			Rank rank9=new Rank(6,"��ҵ");
			Rank rank10=new Rank(7,"ũ��");
			Rank rank11=new Rank(8,"����");
			rankService.update(rank1);
			rankService.update(rank2);
			rankService.update(rank3);
			rankService.update(rank4);
			rankService.update(rank5);
			rankService.update(rank9);
			rankService.update(rank10);
			rankService.update(rank11);
		}
	}
	private void initQuestionType() {
		if(questionTypeService.getCount()==0){
			QuestionType type1=new QuestionType(1,"Υ�����μ�����Ϊ");
			type1.addChild(new QuestionType(2,"����ɢ���������������������"));
			type1.addChild(new QuestionType(3,"��ִ�е��͹��ҷ������߲������"));
			type1.addChild(new QuestionType(4,"Υ�����͹��������ڽ�����"));
			type1.addChild(new QuestionType(5,"��ҥ�����󻯵��͹�������"));
			type1.addChild(new QuestionType(6,"����Υ�����μ�����Ϊ"));
			QuestionType type2=new QuestionType(7,"Υ����֯���¼�����Ϊ");
			type2.addChild(new QuestionType(8,"Υ������������"));
			type2.addChild(new QuestionType(9,"Υ���ɲ�ѡ�����ù涨"));
			type2.addChild(new QuestionType(10,"Υ���ɲ������Ͷ��涨ıȡ����"));
			type2.addChild(new QuestionType(11,"����Υ����֯���¼�����Ϊ"));
			QuestionType type3=new QuestionType(12,"Υ���������ɹ涨��Ϊ");
			type3.addChild(new QuestionType(13,"�Ƿ�ռ�л�ռ��"));
			type3.addChild(new QuestionType(14,"������Ʒ�������"));
			type3.addChild(new QuestionType(15,"Υ�����Ӫ���"));
			type3.addChild(new QuestionType(16,"�ӻ��˷ѹ����Ʋ�"));
			type3.addChild(new QuestionType(17,"Υ��ס���涨"));
			type3.addChild(new QuestionType(18,"����Υ���������ɹ涨��Ϊ"));
			QuestionType type4=new QuestionType(19,"̰�ۻ�¸��Ϊ");
			type4.addChild(new QuestionType(20,"̰��"));
			type4.addChild(new QuestionType(21,"��¸"));
			type4.addChild(new QuestionType(22,"Ų�ù���"));
			type4.addChild(new QuestionType(23,"�޶�Ʋ���Դ����"));
			type4.addChild(new QuestionType(24,"����̰�ۻ�¸��Ϊ"));
			QuestionType type5=new QuestionType(25,"�ƻ�������徭��������Ϊ");
			type5.addChild(new QuestionType(26,"��λŲ���ʽ�"));
			type5.addChild(new QuestionType(27,"�Ƿ���Ӫͬ��ҵ��"));
			type5.addChild(new QuestionType(28,"����ҵ��λ��ԱΪ���ѷǷ�Ĳ��"));
			type5.addChild(new QuestionType(29,"Υ������˰�շ��ɷ���"));
			type5.addChild(new QuestionType(30,"Υ�����ع����ɷ���"));
			type5.addChild(new QuestionType(31,"�����ƻ�������徭��������Ϊ"));
			QuestionType type6=new QuestionType(32,"Υ���ƾ�������Ϊ");
			type6.addChild(new QuestionType(33,"ƭȡ���Ҳ���"));
			type6.addChild(new QuestionType(34,"Υ����ɹ����ʲ���ʧ"));
			type6.addChild(new QuestionType(35,"Υ�������ɹ�����Ͷ�귨�ɷ���"));
			type6.addChild(new QuestionType(36,"����Υ���ƾ�������Ϊ"));
			QuestionType type7=new QuestionType(37,"ʧְ��ְ��Ϊ");
			type7.addChild(new QuestionType(38,"������Ӫ����ʧְ��ְ"));
			type7.addChild(new QuestionType(39,"ִ��ִ��˾��ʧְ��ְ"));
			type7.addChild(new QuestionType(40,"��ȫ�����¹�"));
			type7.addChild(new QuestionType(41,"����ʧְ��ְ��Ϊ"));
			QuestionType type8=new QuestionType(42,"�ַ���ԱȨ������Ȩ����Ϊ");
			type8.addChild(new QuestionType(43,"�ַ�����Ȩ��"));
			type8.addChild(new QuestionType(44,"�ַ�����Ȩ��"));
			type8.addChild(new QuestionType(45,"�������"));
			type8.addChild(new QuestionType(46,"�����ַ���ԱȨ������Ȩ����Ϊ"));
			QuestionType type9=new QuestionType(47,"����Υ��������������Ϊ");
			type9.addChild(new QuestionType(48,"Ū������ƭȡ����"));
			type9.addChild(new QuestionType(49,"ͨ���ػ����"));
			type9.addChild(new QuestionType(50,"��������Υ��������������Ϊ"));
			QuestionType type10=new QuestionType(51,"����������������Ϊ");
			type10.addChild(new QuestionType(52,"ɫ���������"));
			type10.addChild(new QuestionType(53,"Υ���˿���ƻ��������ɷ���"));
			type10.addChild(new QuestionType(54,"����Υ��Υ������"));
			type10.addChild(new QuestionType(55,"��������������������Ϊ"));
			QuestionType type11=new QuestionType(56,"����Υ����Ϊ");
			questionTypeService.update(type1);
			questionTypeService.update(type2);
			questionTypeService.update(type3);
			questionTypeService.update(type4);
			questionTypeService.update(type5);
			questionTypeService.update(type6);
			questionTypeService.update(type7);
			questionTypeService.update(type8);
			questionTypeService.update(type9);
			questionTypeService.update(type10);
			questionTypeService.update(type11);
			
		}
	}
	private void initHandlerWay() {
		if(handlerWayService.getCount()==0){
			HandlerWay handlerWay1=new HandlerWay(1,"������");
			handlerWay1.addChild(new HandlerWay(2,"��������"));
			handlerWay1.addChild(new HandlerWay(3,"ת�¼�����"));
			HandlerWay handlerWay2=new HandlerWay(4,"������ʵ");
			handlerWay2.addChild(new HandlerWay(5,"ֱ�Ӻ�ʵ"));
			handlerWay2.addChild(new HandlerWay(6,"�����˽�"));
			handlerWay2.addChild(new HandlerWay(7,"�����������˵��"));
			handlerWay2.addChild(new HandlerWay(8,"�ֹ��쵼ֱ�ӻ�ί���й����쵼�뱻��ӳ��̸��"));
			handlerWay2.addChild(new HandlerWay(9,"����Ҫ����������̸��"));
			handlerWay2.addChild(new HandlerWay(10,"ί���¼������˽�"));
			handlerWay2.addChild(new HandlerWay(11,"����"));
			HandlerWay handlerWay3=new HandlerWay(12,"�ݴ���");
			HandlerWay handlerWay4=new HandlerWay(13,"������");
			HandlerWay handlerWay5=new HandlerWay(14,"�˽���");
			handlerWay5.addChild(new HandlerWay(15,"ʧʵ"));
			handlerWay5.addChild(new HandlerWay(16,"�ʵ�����"));
			handlerWay5.addChild(new HandlerWay(17,"����"));
			handlerWayService.update(handlerWay1);
			handlerWayService.update(handlerWay2);
			handlerWayService.update(handlerWay3);
			handlerWayService.update(handlerWay4);
			handlerWayService.update(handlerWay5);
		}
	}
}
