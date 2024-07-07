# DARPA: Combating Asymmetric Dark UI Patterns on Android with Run-time View Decorator

It has been extensively discussed that online services, such as shopping websites, may exploit dark user interface (UI) patterns to mislead users into performing unwanted and even harmful activities on the UI, e.g., subscribing to recurring purchases unknowingly. Most recently, the growing popularity of mobile platforms has led to an ever-extending reach of dark UI patterns in mobile apps, leading to security and privacy risks to end users. A systematic study of such patterns, including how to detect and mitigate them on mobile platforms, unfortunately, has not been conducted.

In this paper, we fill the research gap by investigating the dark UI patterns in mobile apps. Specifically, we show the prevalence of the asymmetric dark UI patterns (AUI) in real-world apps, and reveal their risks by characterizing the AUI (e.g., subjects, hosts, and patterns). Then, through user studies, we demonstrate the demand for effective solutions to mitigate the potential risks of AUI. To meet the needs, we propose DARPA – an end-to-end and generic CV-based solution to identify AUIs at run-time, and mitigate the risks by highlighting the AUIs with run-time UI decoration. Our evaluation shows that DARPA is highly accurate and introduces negligible overhead. Additionally, running DARPA does not require any modifications to the apps being analyzed and to the operating system.



This project was forked from https://github.com/nihui/ncnn-android-yolov5

We added our features to defend against AUI. More details can be referenced in our paper.