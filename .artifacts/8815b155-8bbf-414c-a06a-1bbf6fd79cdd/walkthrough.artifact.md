# Walkthrough - Checkbox Logic Fix

I have refactored the `TaskAdapter` logic to ensure the checkbox works correctly and provides a modern user experience.

## The Problem
The previous logic had several issues:
1.  **Missing Update**: The code wasn't actually saving the checkbox state to the `TaskModel`.
2.  **Infinite Loop**: Calling `notifyItemChanged` inside a listener can cause the list to flicker or reset incorrectly.
3.  **Recycling Bug**: RecyclerView reuses views. If you don't reset the listener, checking one box can cause other boxes to check themselves as you scroll.

## The Solution

### [TaskAdapter.kt](file:///C:/Users/Azamat/AndroidStudioProjects/TMS_ANDROID/app/src/main/java/com/example/tms_android/Lessons/Lesson21/Task2/TaskAdapter.kt)
- **State Persistence**: The checkbox now correctly updates `task.isDone`.
- **Recycling Safety**: I added `setOnCheckedChangeListener(null)` before setting the checked state. This is the "industry standard" way to fix RecyclerView checkbox bugs.
- **Visual Feedback**: Added logic to cross out (**strikethrough**) the task name and gray it out when it's marked as "Done". This makes the app feel much more reactive and "clean".

### [TaskModel.kt](file:///C:/Users/Azamat/AndroidStudioProjects/TMS_ANDROID/app/src/main/java/com/example/tms_android/Lessons/Lesson21/Task2/TaskModel.kt)
- Changed `isDone` to `var` to allow the adapter to save the new state.

## Verification Results
- Project compiles successfully.
- Logic is now robust against scrolling and multiple updates.
