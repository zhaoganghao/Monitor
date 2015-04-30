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
 * 初始化 (此action是在系统安装完后就执行)
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
		request.setAttribute("message", "初始化完成");
		request.setAttribute("urladdress", "/login.do");
		return mapping.findForward("message");
	}
	/**
	 * 初始化管理员账号
	 */
	private void initAdmin() {
		if(userService.getCount()==0){
			User user = new User("admin","admin");
			user.setType(1);
			userService.update(user);
		}		
	}
	/**
	 * 初始化系统权限组
	 */
	private void initSource() {
		if(sourceService.getCount()==0){
			Source source1=new Source(1,"来信");
			Source source2=new Source(2,"来访");
			Source source3=new Source(3,"来电");
			Source source4=new Source(4,"网络举报");
			Source source5=new Source(5,"其他");
			sourceService.update(source1);
			sourceService.update(source2);
			sourceService.update(source3);
			sourceService.update(source4);
			sourceService.update(source5);
		}	
	}
	private void initRank() {
		if(rankService.getCount()==0){
			Rank rank1=new Rank(1,"省部级及以上");
			Rank rank2=new Rank(2,"地厅级");
			Rank rank3=new Rank(3,"县处级");
			Rank rank4=new Rank(4,"乡科级");
			Rank rank5=new Rank(5,"一般干部");
			Rank rank9=new Rank(6,"事业");
			Rank rank10=new Rank(7,"农村");
			Rank rank11=new Rank(8,"其他");
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
			QuestionType type1=new QuestionType(1,"违反政治纪律行为");
			type1.addChild(new QuestionType(2,"发表散步有严重政治问题的言论"));
			type1.addChild(new QuestionType(3,"不执行党和国家方针政策部署决定"));
			type1.addChild(new QuestionType(4,"违反党和国家名族宗教政策"));
			type1.addChild(new QuestionType(5,"造谣传播丑化党和国家形象"));
			type1.addChild(new QuestionType(6,"其他违反政治纪律行为"));
			QuestionType type2=new QuestionType(7,"违反组织人事纪律行为");
			type2.addChild(new QuestionType(8,"违反民主集中制"));
			type2.addChild(new QuestionType(9,"违反干部选拔任用规定"));
			type2.addChild(new QuestionType(10,"违反干部人事劳动规定谋取利益"));
			type2.addChild(new QuestionType(11,"其他违反组织人事纪律行为"));
			QuestionType type3=new QuestionType(12,"违反廉洁自律规定行为");
			type3.addChild(new QuestionType(13,"非法占有或占用"));
			type3.addChild(new QuestionType(14,"接受礼品礼金宴请"));
			type3.addChild(new QuestionType(15,"违规从事营利活动"));
			type3.addChild(new QuestionType(16,"挥霍浪费公共财产"));
			type3.addChild(new QuestionType(17,"违反住房规定"));
			type3.addChild(new QuestionType(18,"其他违反廉洁自律规定行为"));
			QuestionType type4=new QuestionType(19,"贪污贿赂行为");
			type4.addChild(new QuestionType(20,"贪污"));
			type4.addChild(new QuestionType(21,"贿赂"));
			type4.addChild(new QuestionType(22,"挪用公款"));
			type4.addChild(new QuestionType(23,"巨额财产来源不明"));
			type4.addChild(new QuestionType(24,"其他贪污贿赂行为"));
			QuestionType type5=new QuestionType(25,"破坏社会主义经济秩序行为");
			type5.addChild(new QuestionType(26,"单位挪用资金"));
			type5.addChild(new QuestionType(27,"非法经营同类业务"));
			type5.addChild(new QuestionType(28,"企事业单位人员为亲友非法牟利"));
			type5.addChild(new QuestionType(29,"违反金融税收法律法规"));
			type5.addChild(new QuestionType(30,"违反土地管理法律法规"));
			type5.addChild(new QuestionType(31,"其他破坏社会主义经济秩序行为"));
			QuestionType type6=new QuestionType(32,"违反财经纪律行为");
			type6.addChild(new QuestionType(33,"骗取国家拨款"));
			type6.addChild(new QuestionType(34,"违规造成国有资产流失"));
			type6.addChild(new QuestionType(35,"违反政府采购和招投标法律法规"));
			type6.addChild(new QuestionType(36,"其他违反财经纪律行为"));
			QuestionType type7=new QuestionType(37,"失职渎职行为");
			type7.addChild(new QuestionType(38,"生产经营管理失职渎职"));
			type7.addChild(new QuestionType(39,"执纪执法司法失职渎职"));
			type7.addChild(new QuestionType(40,"安全责任事故"));
			type7.addChild(new QuestionType(41,"其他失职渎职行为"));
			QuestionType type8=new QuestionType(42,"侵犯党员权利公民权利行为");
			type8.addChild(new QuestionType(43,"侵犯民主权利"));
			type8.addChild(new QuestionType(44,"侵犯人身权利"));
			type8.addChild(new QuestionType(45,"打击报复"));
			type8.addChild(new QuestionType(46,"其他侵犯党员权利公民权利行为"));
			QuestionType type9=new QuestionType(47,"严重违反社会主义道德行为");
			type9.addChild(new QuestionType(48,"弄虚作假骗取荣誉"));
			type9.addChild(new QuestionType(49,"通奸重婚包养"));
			type9.addChild(new QuestionType(50,"其他严重违反社会主义道德行为"));
			QuestionType type10=new QuestionType(51,"妨害社会管理秩序行为");
			type10.addChild(new QuestionType(52,"色情嫖娼淫秽活动"));
			type10.addChild(new QuestionType(53,"违反人口与计划生育法律法规"));
			type10.addChild(new QuestionType(54,"包庇违纪违法犯罪"));
			type10.addChild(new QuestionType(55,"其他妨害社会管理秩序行为"));
			QuestionType type11=new QuestionType(56,"其他违纪行为");
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
			HandlerWay handlerWay1=new HandlerWay(1,"拟立案");
			handlerWay1.addChild(new HandlerWay(2,"本级立案"));
			handlerWay1.addChild(new HandlerWay(3,"转下级立案"));
			HandlerWay handlerWay2=new HandlerWay(4,"初步核实");
			handlerWay2.addChild(new HandlerWay(5,"直接核实"));
			handlerWay2.addChild(new HandlerWay(6,"侧面了解"));
			handlerWay2.addChild(new HandlerWay(7,"发函请作情况说明"));
			handlerWay2.addChild(new HandlerWay(8,"分管领导直接或委托有关室领导与被反映人谈话"));
			handlerWay2.addChild(new HandlerWay(9,"请主要负责人与其谈话"));
			handlerWay2.addChild(new HandlerWay(10,"委托下级机关了解"));
			handlerWay2.addChild(new HandlerWay(11,"其他"));
			HandlerWay handlerWay3=new HandlerWay(12,"暂存类");
			HandlerWay handlerWay4=new HandlerWay(13,"留存类");
			HandlerWay handlerWay5=new HandlerWay(14,"了结类");
			handlerWay5.addChild(new HandlerWay(15,"失实"));
			handlerWay5.addChild(new HandlerWay(16,"适当处理"));
			handlerWay5.addChild(new HandlerWay(17,"其他"));
			handlerWayService.update(handlerWay1);
			handlerWayService.update(handlerWay2);
			handlerWayService.update(handlerWay3);
			handlerWayService.update(handlerWay4);
			handlerWayService.update(handlerWay5);
		}
	}
}
