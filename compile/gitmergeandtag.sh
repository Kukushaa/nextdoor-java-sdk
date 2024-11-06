#!/bin/bash

merge_and_tag() {
    local branch=$1
    local tag_name="$branch"

    current_branch=$(git branch --show-current)
    if [ "$current_branch" == "main" ]; then
        echo "You are already on the 'main' branch. No merging required."
        exit 0
    fi

    if [ "$current_branch" != "$branch" ]; then
        if git show-ref --verify --quiet "refs/heads/$branch"; then
            echo "Switching to branch $branch"
            git checkout "$branch"
        else
            echo "Branch '$branch' not found. Exiting."
            exit 1
        fi
    else
        echo "Already on branch $branch"
    fi

    echo "Merging $branch into main"
    git checkout main
    git merge "$branch"
    git push origin main

    echo "Creating tag $tag_name"
    git tag "$tag_name"

    echo "Pushing main and tag to GitHub"
    git push origin --tags

    echo "Merge, tag, and push completed."
}

cd ..

echo "Choose setup mode: (1) Auto or (2) Manual"
read -p "Enter 1 or 2: " choice

if [ "$choice" -eq 1 ]; then
    echo "Auto-detecting branch..."
    current_branch=$(git branch --show-current)
    if [ -z "$current_branch" ]; then
        echo "No current branch detected. Exiting."
        exit 1
    fi

    echo "Detected branch: $current_branch"
    merge_and_tag "$current_branch"

elif [ "$choice" -eq 2 ]; then
    read -p "Enter branch name: " branch_name
    merge_and_tag "$branch_name"
else
    echo "Invalid choice. Exiting."
    exit 1
fi