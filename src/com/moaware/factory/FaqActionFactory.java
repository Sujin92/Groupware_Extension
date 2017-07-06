package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.faq.action.FaqDeleteAction;
import com.moaware.faq.action.FaqListAction;
import com.moaware.faq.action.FaqModifyAction;
import com.moaware.faq.action.FaqMoveModifyAction;
import com.moaware.faq.action.FaqViewAction;
import com.moaware.faq.action.FaqWriteAction;

public class FaqActionFactory {
		
		private static Action faqListAction;
		private static Action faqWriteAction;
		private static Action faqViewAction;
		private static Action faqModifyAction;
		private static Action faqDeleteAction;
		private static Action faqMoveModifyAction;
		
		static{
			faqListAction = new FaqListAction();
			faqWriteAction = new FaqWriteAction();
			faqViewAction = new FaqViewAction();
			faqModifyAction = new FaqModifyAction();
			faqDeleteAction = new FaqDeleteAction();
			faqMoveModifyAction = new FaqMoveModifyAction();
		}

		public static Action getFaqListAction() {
			return faqListAction;
		}

		public static Action getFaqWriteAction() {
			return faqWriteAction;
		}

		public static Action getFaqViewAction() {
			return faqViewAction;
		}

		public static Action getFaqModifyAction() {
			return faqModifyAction;
		}

		public static Action getFaqDeleteAction() {
			return faqDeleteAction;
		}

		public static Action getFaqMoveModifyAction() {
			return faqMoveModifyAction;
		}

	}
