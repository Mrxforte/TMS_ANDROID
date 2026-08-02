# Implementation Plan - Push Changes Branch by Branch

The goal is to organize the current uncommitted changes into logical Git branches (e.g., by Lesson or Task) and push them to the remote repository.

## User Review Required

> [!IMPORTANT]
> Some files (like `AndroidManifest.xml`, `strings.xml`, and `LessonTasksActivity.kt`) contain changes for multiple tasks. Pushing them in the first branch will include code for all tasks in that file unless we carefully stage specific lines.
>
> **Recommendation**: I will create one branch per **Lesson** (e.g., `lesson-21`, `lesson-22`) to keep the common files consistent, unless you specifically want one branch per **Task**.

## Proposed Branches

### 1. `lesson-21`
- **Files**:
  - All files in `com.example.tms_android.Lessons.Lesson21`
  - `app/src/main/res/layout/activity_lesson21_task1.xml`
  - `app/src/main/res/layout/activity_lesson21_task2.xml`
  - `app/src/main/res/layout/activity_lesson21_task3.xml`
  - `app/src/main/res/layout/student_item.xml`
  - `app/src/main/res/layout/todo_item.xml`
  - `app/src/main/res/layout/student_card.xml`
  - Partial changes in `AndroidManifest.xml`, `strings.xml`, `LessonTasksActivity.kt`

### 2. `lesson-22`
- **Files**:
  - `app/src/main/java/com/example/tms_android/Lessons/Lesson22/`
  - `app/src/main/res/layout/activity_lesson22_*.xml`
  - `app/src/main/res/layout/user_item.xml`

### 3. `lesson-26`
- **Files**:
  - `app/src/main/java/com/example/tms_android/Lessons/Lesson26/`
  - `app/src/main/res/layout/activity_lesson26_task1.xml`

### 4. `lesson-27`
- **Files**:
  - `app/src/main/java/com/example/tms_android/Lessons/Lesson27/`
  - `app/src/main/res/layout/activity_lesson27_task1.xml`
  - `app/src/main/res/layout/item_post.xml`

## Workflow for each branch:
1. `git checkout -b <branch_name>`
2. `git add <specific_files>`
3. `git commit -m "Add changes for <branch_name>"`
4. `git push origin <branch_name>`
5. `git checkout master`

## Open Questions
- Do you want one branch per **Task** (e.g., `lesson-21-task1`) or per **Lesson** (e.g., `lesson-21`)?
- Should I include the `.artifacts` directory in the commits? (Usually, these are for my own tracking and shouldn't be in the repo).
