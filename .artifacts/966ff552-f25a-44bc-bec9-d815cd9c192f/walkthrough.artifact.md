# Walkthrough - Lesson 21 Task 1 Enhancements

I have fixed the issue where Lesson 21 tasks were not showing in the main list and added the "Add Student" functionality to Task 1.

## Changes

### 1. Task List Fix
- **[LessonTasksActivity.kt](file:///C:/Users/Azamat/AndroidStudioProjects/TMS_ANDROID/app/src/main/java/com/example/tms_android/LessonTasksActivity.kt)**: Added Lesson 21 to the task list logic. Now, when you select Lesson 21, "Task 1" will correctly appear in the list.

### 2. "Add Student" UI and Logic
- **[StudentModel.kt](file:///C:/Users/Azamat/AndroidStudioProjects/TMS_ANDROID/app/src/main/java/com/example/tms_android/Lessons/Lesson21/Task1/StudentModel.kt)**: Changed `rate` from `val` to `var` to allow updating the rating when an item is clicked.
- **[activity_lesson21_task1.xml](file:///C:/Users/Azamat/AndroidStudioProjects/TMS_ANDROID/app/src/main/res/layout/activity_lesson21_task1.xml)**: Added a header section with two `EditText` fields (Name and Rate) and an "Add Student" `Button`. The `RecyclerView` now sits below these inputs.
- **[StudentAdapter.kt](file:///C:/Users/Azamat/AndroidStudioProjects/TMS_ANDROID/app/src/main/java/com/example/tms_android/Lessons/Lesson21/Task1/StudentAdapter.kt)**:
    - Added a "No data" empty state.
    - Optimized the `ViewHolder` by caching `TextView` references.
    - Fixed the click listener to increment the `rate` in the data model and refresh the item.
- **[Lesson21Task1.kt](file:///C:/Users/Azamat/AndroidStudioProjects/TMS_ANDROID/app/src/main/java/com/example/tms_android/Lessons/Lesson21/Task1/Lesson21Task1.kt)**: Implemented the logic to add a new `StudentModel` to the list when the "Add" button is clicked and notified the adapter of the change.

## Verification Results

### Automated Tests
- Ran `gradlew :app:assembleDebug` and the build finished successfully.

### Manual Verification
- You can now find Lesson 21 in the app's lesson list.
- In Lesson 21 Task 1, you will see a "No data" message initially.
- Entering a name and rate and clicking "Add Student" will add the student to the list.
- Clicking on a student in the list will increment their rating.
